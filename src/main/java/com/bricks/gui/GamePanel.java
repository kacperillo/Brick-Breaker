package com.bricks.gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        super();
        setMaximumSize(GuiConfig.FRAME_DIMENSION);
        setMinimumSize(GuiConfig.FRAME_DIMENSION);
        setBackground(GuiConfig.BACKGROUND_COLOR);
        setForeground(GuiConfig.FOREGROUND_COLOR);
    }
}
