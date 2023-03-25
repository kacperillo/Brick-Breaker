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
        setMinimumSize(new Dimension(300, 170));
        setMaximumSize(new Dimension(300, 170));
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
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        playAgainButton,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        180,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        backButton,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        180,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(message)
                                .addGap(80, 80, 80)
                                .addComponent(playAgainButton)
                                .addGap(30, 30, 30)
                                .addComponent(
                                        backButton,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(250, Short.MAX_VALUE))
        );
    }
}

