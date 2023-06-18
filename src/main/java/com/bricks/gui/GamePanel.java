package com.bricks.gui;

import com.bricks.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {

    private final Controller controller;

    public GamePanel(Controller controller) {
        super();
        this.controller = controller;
        setMaximumSize(GuiConfig.FRAME_DIMENSION);
        setMinimumSize(GuiConfig.FRAME_DIMENSION);
        setBackground(GuiConfig.BACKGROUND_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
        addKeyListener(new GameKeyAdapter());
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        controller.paintGame(g);
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
