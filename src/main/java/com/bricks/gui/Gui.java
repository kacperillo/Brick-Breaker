package com.bricks.gui;

import com.bricks.Config;
import com.bricks.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Gui extends JFrame {

    private final Controller controller;
    private StartPanel startPanel;
    private JPanel gamePanel;
    private JDialog dialog;
    private Timer timer;

    public Gui(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        setTitle("Break Breaker");
        pack();
        setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeApp();
            }
        });

        startPanel = new StartPanel();
        gamePanel = new GamePanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                controller.paintGame((Graphics2D)g);
            }
        };

        startPanel.getPlayButton().addActionListener(e -> {
            startGame();
        });

        startPanel.getQuitButton().addActionListener(
                e -> closeApp());

        gamePanel.addKeyListener(new GameKeyAdapter());

        setContentPane(startPanel);
        setVisible(true);
    }


    private void startGame() {
        setContentPane(gamePanel);
        gamePanel.requestFocus();
        controller.startGame();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
                revalidate();
            }
        }, 0, Config.PERIOD);
    }

    public void stopGame() {


    }

    private void closeApp() {
        dialog = new JDialog(this);
        ExitConfirmPane exitConfirmPane = new ExitConfirmPane();
        dialog.setSize(300, 120);
        dialog.setResizable(false);
        dialog.setUndecorated(true);
        dialog.setContentPane(exitConfirmPane);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        exitConfirmPane.getYesButton().addActionListener(
                e -> System.exit(0));

        exitConfirmPane.getNoButton().addActionListener(
                e -> dialog.dispose());
        dialog.setVisible(true);
    }


    private class GameKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                controller.setPaddleLeftMoveFlag(true);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                controller.setPaddleRightMoveFlag(true);
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                controller.setPaddleLeftMoveFlag(false);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                controller.setPaddleRightMoveFlag(false);
            }
        }
    }
}
