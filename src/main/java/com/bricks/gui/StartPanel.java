package com.bricks.gui;

import com.bricks.Controller;

import javax.swing.*;

public class StartPanel extends JPanel {

    private final Controller controller;

    public StartPanel(Controller controller) {
        super();
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        setBackground(GuiConfig.BACKGROUND_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
        setMaximumSize(GuiConfig.FRAME_DIMENSION);
        setMinimumSize(GuiConfig.FRAME_DIMENSION);

        JButton playButton = new GameButton("PLAY", GameButton.Size.DEFAULT);
        JButton quitButton = new GameButton("QUIT", GameButton.Size.DEFAULT);
        playButton.addActionListener(
                e -> controller.startGame());

        quitButton.addActionListener(
                e -> new ExitConfirmationDialog(controller));

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
}
