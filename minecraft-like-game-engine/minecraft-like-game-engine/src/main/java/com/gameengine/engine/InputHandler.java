package com.gameengine.engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputHandler extends KeyAdapter implements MouseListener {
    private Renderer renderer;
    private boolean[] keys = new boolean[256];
    private boolean leftMousePressed = false;
    private boolean rightMousePressed = false;

    public InputHandler(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:  renderer.moveBlock(-10, 0); break;
            case KeyEvent.VK_RIGHT: renderer.moveBlock(10, 0); break;
            case KeyEvent.VK_UP:    renderer.moveBlock(0, -10); break;
            case KeyEvent.VK_DOWN:  renderer.moveBlock(0, 10); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public void processInput() {
        // Process input logic here if needed
    }

    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        renderer.addBlock(e.getX() - 20, e.getY() - 20); // Center block on click
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftMousePressed = true;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightMousePressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftMousePressed = false;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightMousePressed = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not used
    }

    public boolean isLeftMousePressed() {
        return leftMousePressed;
    }

    public boolean isRightMousePressed() {
        return rightMousePressed;
    }
}