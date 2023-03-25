package com.bricks.gui;

import javax.swing.*;
import java.awt.*;

public class ExitConfirmationDialog extends JDialog {

    private final JButton yesButton;
    private final JButton noButton;

    public ExitConfirmationDialog() {

        super();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        yesButton = new GameButton("YES", GameButton.Size.SMALL);
        noButton = new GameButton("NO", GameButton.Size.SMALL);
        yesButton.setBackground(GuiConfig.WARNING_COLOR);

        yesButton.addActionListener(
                e -> System.exit(0));

        noButton.addActionListener(
                e -> dispose());

        setContentPane(new ExitConfirmPane());
        setSize(GuiConfig.DIALOG_WIDTH, GuiConfig.DIALOG_HEIGHT);
        setLocation(GuiConfig.SCREEN_WIDTH/2 - GuiConfig.DIALOG_WIDTH/2,
                    GuiConfig.SCREEN_HEIGHT/2 - GuiConfig.DIALOG_HEIGHT/2);
        setResizable(false);
        setUndecorated(true);
        setAlwaysOnTop(true);

        getRootPane().setDefaultButton(noButton);
        setVisible(true);
        noButton.requestFocus();
    }

    private class ExitConfirmPane extends JPanel {

        public ExitConfirmPane() {
            initComponents();
        }

        private void initComponents() {

            setBackground(GuiConfig.BACKGROUND_COLOR);
            setForeground(GuiConfig.FOREGROUND_COLOR);
            setMinimumSize(new Dimension(250, 120));
            setMaximumSize(new Dimension(250, 120));
            setBorder(BorderFactory.createLineBorder(Color.WHITE));

            JLabel message = new JLabel();
            message.setFont(GuiConfig.DEFAULT_FONT);
            message.setForeground(GuiConfig.FOREGROUND_COLOR);
            message.setHorizontalAlignment(SwingConstants.CENTER);
            message.setText("Are you sure you want to exit?");

            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(
                                    message,
                                    GroupLayout.Alignment.TRAILING,
                                    GroupLayout.DEFAULT_SIZE,
                                    328,
                                    Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addComponent(yesButton)
                                    .addGap(47, 47, 47)
                                    .addComponent(noButton)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(
                                            message,
                                            GroupLayout.PREFERRED_SIZE,
                                            51,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(yesButton)
                                            .addComponent(noButton))
                                    .addContainerGap(30, Short.MAX_VALUE))
            );
        }
    }
}
