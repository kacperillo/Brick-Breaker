package com.bricks.gui;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {

    public GameButton(String text) {
        super();
        setBackground(GuiConfig.BUTTON_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
        setFont(GuiConfig.DEFAULT_FONT);
        setText(text);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFocusable(false);
    }
}
