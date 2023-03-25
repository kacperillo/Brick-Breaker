package com.bricks.gui;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {

    public GameButton(String text, Size buttonSize) {
        super();
        setBackground(GuiConfig.BUTTON_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
        if (buttonSize == Size.DEFAULT) {
            setFont(GuiConfig.DEFAULT_FONT);
        } else {
            setFont(GuiConfig.SMALL_FONT);
        }
        setText(text);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFocusable(false);
    }

    public enum Size {
        SMALL, DEFAULT;
    }
}
