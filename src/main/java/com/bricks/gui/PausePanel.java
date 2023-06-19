package com.bricks.gui;

import com.bricks.Controller;

import javax.swing.*;
import java.awt.*;

public class PausePanel extends JPanel {


    public PausePanel(Controller controller) {
        super();

        JLabel message = new JLabel();
        message.setFont(GuiConfig.DEFAULT_FONT);
        message.setForeground(GuiConfig.FOREGROUND_COLOR);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setText("Game Paused");

        JButton resumeButton = new GameButton("Resume", GameButton.Size.DEFAULT);
        resumeButton.setBackground(GuiConfig.WARNING_COLOR);
        resumeButton.addActionListener(e -> controller.resume());

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
                                        .addComponent(
                                                resumeButton,
                                                GroupLayout.PREFERRED_SIZE,
                                                100,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(message)
                                .addGap(30, 30, 30)
                                .addComponent(resumeButton)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
    }
}
