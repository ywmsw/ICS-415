package com.gameengine.engine;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameEngine {
    private Renderer renderer;
    private InputHandler inputHandler;
    private JFrame frame;
    private GamePanel panel;
    private Timer timer;

    public GameEngine() {
    this.renderer = new Renderer();
    this.inputHandler = new InputHandler(this.renderer); // Pass renderer here
}

    public void start() {
       // running = true;
        initialize();
        setupWindow();
        startGameLoop();
    }

    private void initialize() {
        renderer.initialize();
    }

    private void setupWindow() {
        frame = new JFrame("Minecraft-Like Game Engine");
        panel = new GamePanel(renderer);
        inputHandler = new InputHandler(renderer);
        panel.addKeyListener(inputHandler);
        panel.addMouseListener(inputHandler); // <-- Add this line
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel);
        frame.setVisible(true);
        panel.requestFocusInWindow();
    }

    private void startGameLoop() {
        timer = new Timer(16, new ActionListener() { // ~60 FPS
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                panel.repaint();
                processInput();
            }
        });
        timer.start();
    }

    

    private void update() {
        // Update game state logic here
    }

    private void processInput() {
        inputHandler.processInput();
    }

    public void stop() {
       // running = false;
        if (timer != null) timer.stop();
        if (frame != null) frame.dispose();
    }
}