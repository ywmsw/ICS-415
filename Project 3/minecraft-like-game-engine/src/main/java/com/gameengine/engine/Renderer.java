package com.gameengine.engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
    private List<Point> blocks = new ArrayList<>();

    public void initialize() {
        blocks.clear();
        blocks.add(new Point(100, 100)); // Initial block
    }

    public void moveBlock(int dx, int dy) {
        if (!blocks.isEmpty()) {
            Point p = blocks.get(0);
            p.translate(dx, dy);
        }
    }

    public void addBlock(int x, int y) {
        blocks.add(new Point(x, y));
    }

    public void clearScreen(Graphics g) {
        // Draw garden background with green grass and trees
        g.setColor(new Color(100, 200, 100)); // Grass
        g.fillRect(0, 0, 800, 600);

        // Draw some trees
        for (int i = 0; i < 6; i++) {
            int tx = 100 + i * 120;
            // Trunk
            g.setColor(new Color(120, 70, 20));
            g.fillRect(tx + 20, 350, 20, 60);
            // Leaves
            g.setColor(new Color(34, 139, 34));
            g.fillOval(tx, 320, 60, 60);
        }
    }

    public void renderBlock(Graphics g) {
        g.setColor(Color.BLUE);
        for (Point p : blocks) {
            g.fillRect(p.x, p.y, 40, 40);
        }
    }
}