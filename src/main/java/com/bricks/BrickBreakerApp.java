package com.bricks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class BrickBreakerApp extends JFrame {


    private StartPanel startPanel;
    private JPanel gamePanel;
    private Game game;
    private Timer timer;

    public static void main(String[] args) {
        EventQueue.invokeLater(BrickBreakerApp::new);
    }

    public BrickBreakerApp() {
        initComponents();
    }

    private void initComponents() {

        setTitle("Break Breaker");
        setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        startPanel = new StartPanel();
        gamePanel = new GamePanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                game.paint((Graphics2D)g);
            }
        };

        startPanel.getPlayButton().addActionListener(e -> {
            setContentPane(gamePanel);
            gamePanel.requestFocus();
            startGame();
        });

        startPanel.getQuitButton().addActionListener(
                e -> System.exit(0));

        gamePanel.addKeyListener(new GameKeyAdapter());

        setContentPane(startPanel);
        setVisible(true);
    }


    private void startGame() {
        timer = new Timer();
        game = new Game();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
                revalidate();
            }
        }, 0, 16);
    }

    private class GameKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                game.setPaddleLeftMoveFlag(true);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                game.setPaddleRightMoveFlag(true);
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                game.setPaddleLeftMoveFlag(false);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                game.setPaddleRightMoveFlag(false);
            }
        }
    }
}