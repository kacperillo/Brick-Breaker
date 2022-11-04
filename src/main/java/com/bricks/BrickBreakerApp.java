package com.bricks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class BrickBreakerApp extends JFrame {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private Graphics2D g;
    private JPanel startPanel, gamePanel;
    private JButton playButton, exitButton;
    private JLabel welcomeLabel;
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
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        startPanel = new JPanel();
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                game.paint((Graphics2D)g);
            }
        };


        addListeners();
        setContentPane(startPanel);
        setVisible(true);
    }

    private void addListeners() {

        playButton.addActionListener(event -> {
            setContentPane(gamePanel);
            startGame();
//                revalidate();
        });

        exitButton.addActionListener(event -> System.exit(0));
    }


    private void startGame() {
        timer = new Timer();
        game = new Game();
        addKeyListener();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
                revalidate();
            }
        }, 0, 16);
    }


    private void addKeyListener() {
        addKeyListener(new KeyAdapter() {
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
        });
        setFocusable(true);
        requestFocus();
    }
}