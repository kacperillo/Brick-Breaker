package com.bricks.gui;

import com.bricks.Controller;

import javax.swing.*;
import java.awt.*;

public class EndGamePanel extends JPanel {

    private final Controller controller;
    private JLabel message;
    private JButton playAgainButton;
    private JButton backButton;

    public EndGamePanel(Controller controller) {
        super();
        this.controller = controller;
        message = new JLabel();
        message.setFont(GuiConfig.DEFAULT_FONT);
        message.setForeground(GuiConfig.FOREGROUND_COLOR);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setText("END");

        playAgainButton = new GameButton("PLAY AGAIN", GameButton.Size.DEFAULT);
        backButton = new GameButton("BACK", GameButton.Size.DEFAULT);

        playAgainButton.addActionListener(
                e -> controller.startGame());

        backButton.addActionListener(
                e -> controller.backToStart());

        setBackground(GuiConfig.BACKGROUND_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
        setMinimumSize(new Dimension(350, 300));
        setMaximumSize(new Dimension(350, 300));
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(
                                message,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        backButton,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        200,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        playAgainButton,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        200,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(message)
                                .addGap(30, 30, 30)
                                .addComponent(playAgainButton)
                                .addGap(30, 30, 30)
                                .addComponent(
                                        backButton,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
    }
}

