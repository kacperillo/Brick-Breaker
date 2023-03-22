package com.bricks.gui;

import javax.swing.*;
import java.awt.*;

public class ExitConfirmPane extends JPanel {


    private final JButton yesButton;
    private final JButton noButton;
    private JLabel message;
    
    public ExitConfirmPane(JButton yesButton, JButton noButton) {
        this.yesButton = yesButton;
        this.noButton = noButton;
        initComponents();
    }

    private void initComponents() {

        message = new JLabel();

        setBackground(GuiConfig.BACKGROUND_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
        setMinimumSize(new Dimension(250, 120));
        setPreferredSize(new Dimension(250, 120));
        setMaximumSize(new Dimension(250, 120));
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        message.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        message.setForeground(new Color(255, 255, 255));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setText("Are you sure you want to exit?");

        yesButton.setBackground(new Color(255, 29, 0));
        yesButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // NOI18N
        yesButton.setForeground(new Color(255, 255, 255));
        yesButton.setText("Yes");
        yesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        noButton.setBackground(new Color(0, 153, 153));
        noButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14)); // NOI18N
        noButton.setForeground(new Color(255, 255, 255));
        noButton.setText("No");
        noButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        noButton.requestFocus();

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(message, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
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
                .addComponent(message, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(yesButton)
                    .addComponent(noButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }
}
