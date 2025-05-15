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

  // Draw Bézier curves and connecting lines
  for (let i = 0; i + 3 < controlPoints.length; i += 4) {
    let p0 = controlPoints[i];
    let p1 = controlPoints[i + 1];
    let p2 = controlPoints[i + 2];
    let p3 = controlPoints[i + 3];

    // Connecting lines between points
    stroke(150);
    line(p0.x, p0.y, p1.x, p1.y); // Line between P1 and P2
    line(p1.x, p1.y, p2.x, p2.y); // Line between P2 and P3
    line(p2.x, p2.y, p3.x, p3.y); // Line between P3 and P4

    // Bézier curve between P1 and P4
    stroke(0);
    bezier(p0.x, p0.y, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
  }

  // Draw control points (anchors and handles)
  for (let i = 0; i < controlPoints.length; i++) {
    if (i % 4 === 0) {
      fill('blue'); // Anchor points (P1, P4)
    } else {
      fill('red');  // Control handles (P2, P3)
    }
    noStroke();
    ellipse(controlPoints[i].x, controlPoints[i].y, 10, 10);
  }
}

function addCurve() {
  // If this is the first curve, add 4 points
  if (controlPoints.length === 0) {
    controlPoints.push(createVector(100, 100)); // P1
    controlPoints.push(createVector(200, 200)); // P2
    controlPoints.push(createVector(300, 150)); // P3
    controlPoints.push(createVector(400, 250)); // P4
  } else {
    // For subsequent curves: Start from the last point of the previous curve (P4)
    let lastP = controlPoints[controlPoints.length - 1]; // Last point (P4 of the previous curve)
    let secondLastP = controlPoints[controlPoints.length - 2]; // Second last point (P3 of the previous curve)

    // Calculate direction of the last segment (P3 -> P4)
    let direction = p5.Vector.sub(lastP, secondLastP);

    // Add new curve with 3 new points (P1, P2, P3) and set the last point as P4
    controlPoints.push(createVector(lastP.x, lastP.y)); // P1 (same as last P4)
    controlPoints.push(createVector(lastP.x + direction.x, lastP.y + direction.y)); // P2 (aligned with direction)
    controlPoints.push(createVector(lastP.x + 200, lastP.y - 50)); // P3 (arbitrary offset)
    controlPoints.push(createVector(lastP.x + 300, lastP.y + 50)); // P4 (arbitrary offset)
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
  saveCanvas('myCanvas', 'png');
}