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
    private EndGamePanel endGamePanel;
    private Timer timer;

    public Gui(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        setTitle("Break Breaker");
        pack();
        setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new ExitConfirmationDialog();
            }
        });

        startPanel = new StartPanel(controller);
        gamePanel = new GamePanel(controller);
        endGamePanel = new EndGamePanel(controller);

        setLocation(GuiConfig.SCREEN_WIDTH/2 - GuiConfig.FRAME_DIMENSION.width/2,
                GuiConfig.SCREEN_HEIGHT/2 - GuiConfig.FRAME_DIMENSION.height/2);
        setResizable(false);
        setContentPane(startPanel);
        setVisible(true);
    }

    public void startDrawingGame() {
        setContentPane(gamePanel);
        gamePanel.requestFocus();
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
        timer.cancel();
        getContentPane().add(endGamePanel);
    }

    private void backToMainMenu() {

    }
}
