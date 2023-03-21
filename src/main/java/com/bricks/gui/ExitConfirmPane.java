package com.bricks.gui;

import javax.swing.*;
import java.awt.*;

public class ExitConfirmPane extends JPanel {


    private JButton yesButton;
    private JButton noButton;
    private JLabel message;
    
    public ExitConfirmPane() {
        initComponents();
    }

    private void initComponents() {

        message = new JLabel();
        yesButton = new JButton();
        noButton = new JButton();

        setBackground(GuiConfig.BACKGROUND_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
        setMinimumSize(new Dimension(250, 120));
        setPreferredSize(new Dimension(250, 120));
        setMaximumSize(new Dimension(250, 120));

        message.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        message.setForeground(new Color(255, 255, 255));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setText("Are you sure you want to exit?");

        yesButton.setBackground(new Color(0, 153, 153));
        yesButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // NOI18N
        yesButton.setForeground(new Color(255, 255, 255));
        yesButton.setText("No");
        yesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        noButton.setBackground(new Color(255, 29, 0));
        noButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // NOI18N
        noButton.setForeground(new Color(255, 255, 255));
        noButton.setText("Yes");
        noButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(message, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(noButton)
                .addGap(47, 47, 47)
                .addComponent(yesButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(message, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(noButton)
                    .addComponent(yesButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }

    public JButton getYesButton() {
        return yesButton;
    }

    public JButton getNoButton() {
        return noButton;
    }
}
