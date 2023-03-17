package com.bricks;

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

        setBackground(new Color(11, 3, 3));
        setForeground(new Color(255, 255, 255));
        setMaximumSize(new Dimension(500, 500));
        setMinimumSize(new Dimension(500, 500));

        playButton = new StartButton("PLAY");
        quitButton = new StartButton("QUIT");

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        welcomeLabel.setForeground(new Color(255, 255, 255));
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

    private static class StartButton extends JButton {

        public StartButton(String text) {
            super();
            setBackground(new Color(0, 153, 153));
            setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            setForeground(new Color(255, 255, 255));
            setText(text);
            setBorderPainted(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setFocusable(false);
        }
    }
}
