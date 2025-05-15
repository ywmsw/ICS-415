package com.gameengine.engine;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {
    private Renderer renderer;

    public GamePanel(Renderer renderer) {
        this.renderer = renderer;
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderer.clearScreen(g);
        renderer.renderBlock(g);
    }
}