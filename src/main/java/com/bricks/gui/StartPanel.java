package com.bricks.gui;

import com.bricks.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartPanel extends javax.swing.JPanel {

    private JButton playButton;
    private JButton quitButton;

    public StartPanel() {
        super();
        initComponents();
    }

    private void initComponents() {

        setBackground(GuiConfig.BACKGROUND_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
        setMaximumSize(GuiConfig.FRAME_DIMENSION);
        setMinimumSize(GuiConfig.FRAME_DIMENSION);

        playButton = new GameButton("PLAY");
        quitButton = new GameButton("QUIT");
        JLabel welcomeLabel = new JLabel();

        welcomeLabel.setFont(GuiConfig.BIG_FONT);
        welcomeLabel.setForeground(GuiConfig.FOREGROUND_COLOR);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setText("Brick Breaker Game");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(
                                welcomeLabel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        quitButton,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        180,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        playButton,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        180,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(welcomeLabel)
                                .addGap(80, 80, 80)
                                .addComponent(playButton)
                                .addGap(30, 30, 30)
                                .addComponent(
                                        quitButton,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(250, Short.MAX_VALUE))
        );
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }


}
