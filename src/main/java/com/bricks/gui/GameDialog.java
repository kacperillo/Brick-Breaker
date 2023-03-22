package com.bricks.gui;

import javax.swing.*;
import java.awt.*;

public class GameDialog extends JDialog {

    public GameDialog() {
        super();
        JButton yesButton = new JButton();
        JButton noButton = new JButton();
        ExitConfirmPane exitConfirmPane = new ExitConfirmPane(yesButton, noButton);
        setSize(GuiConfig.DIALOG_WIDTH, GuiConfig.DIALOG_HEIGHT);
        setLocation(GuiConfig.SCREEN_WIDTH/2 - GuiConfig.DIALOG_WIDTH/2,
                    GuiConfig.SCREEN_HEIGHT/2 - GuiConfig.DIALOG_HEIGHT/2);
        setResizable(false);
        setUndecorated(true);
        setContentPane(exitConfirmPane);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);

        yesButton.addActionListener(
                e -> System.exit(0));

        noButton.addActionListener(
                e -> dispose());
        getRootPane().setDefaultButton(noButton);
        setVisible(true);
        noButton.requestFocus();
    }
}
