let controlPoints = [];
let draggingPoint = null;
let draggingOffset;

function setup() {
  let canvas = createCanvas(800, 600);
  canvas.parent('canvas-holder');
}

function draw() {
  background(255);

  strokeWeight(2);
  noFill();

  // Draw Bézier curves (every set of 4 points forms a curve)
  for (let i = 0; i + 3 < controlPoints.length; i += 3) {
    let p0 = controlPoints[i];
    let p1 = controlPoints[i + 1];
    let p2 = controlPoints[i + 2];
    let p3 = controlPoints[i + 3];

    stroke(0);
    bezier(p0.x, p0.y, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
  }

  // Draw control points (anchors and handles)
  for (let i = 0; i < controlPoints.length; i++) {
    if (i % 3 === 0) {
      fill('blue'); // Anchor points
    } else {
      fill('red');  // Control handles
    }
    noStroke();
    ellipse(controlPoints[i].x, controlPoints[i].y, 10, 10);
  }
}

function mousePressed() {
  // Check if we're clicking on a control point to drag it
  for (let i = 0; i < controlPoints.length; i++) {
    if (dist(mouseX, mouseY, controlPoints[i].x, controlPoints[i].y) < 10) {
      draggingPoint = i;
      draggingOffset = createVector(mouseX - controlPoints[i].x, mouseY - controlPoints[i].y);
      return;
    }
  }

  // Add points after the first 4: each new curve starts from the last point of the previous one
  if (controlPoints.length < 4) {
    controlPoints.push(createVector(mouseX, mouseY));
  } else {
    // Only allow adding in sets of 3 (because 4th point = last anchor of previous curve)
    const extraPoints = controlPoints.length - 4;
    if (extraPoints % 3 === 0) {
      controlPoints.push(createVector(mouseX, mouseY));
    } else {
      controlPoints.push(createVector(mouseX, mouseY));
    }
  }
}

function mouseDragged() {
  if (draggingPoint !== null) {
    controlPoints[draggingPoint] = createVector(mouseX - draggingOffset.x, mouseY - draggingOffset.y);
  }
}

function mouseReleased() {
  draggingPoint = null;
}

function clearCanvas() {
  controlPoints = [];
}
function saveCanvasAsImage() {
  saveCanvas('bezier-curves', 'png');
}