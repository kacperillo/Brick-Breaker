package com.bricks.gui;

import com.bricks.Config;
import com.bricks.Controller;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Gui extends JFrame {

    private final Controller controller;
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

        setLocation(GuiConfig.SCREEN_WIDTH/2 - GuiConfig.FRAME_DIMENSION.width/2,
                GuiConfig.SCREEN_HEIGHT/2 - GuiConfig.FRAME_DIMENSION.height/2);

        setResizable(false);
        setContentPane(new StartPanel(controller));
        setVisible(true);
    }

    public void startDrawingGame() {
        GamePanel gamePanel = new GamePanel(controller);
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

    public void stopGame(boolean isWin) {
        timer.cancel();
        EndGamePanel endGamePanel;
        if(isWin) {
            endGamePanel = new WinPanel(controller);
        } else {
            endGamePanel = new GameOverPanel(controller);
        }
        getContentPane().add(endGamePanel);
        repaint();
        revalidate();
    }

    public void backToMainMenu() {
        setContentPane(new StartPanel(controller));
        repaint();
        revalidate();
    }
}
