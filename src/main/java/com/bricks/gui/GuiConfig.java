package com.bricks.gui;

import com.bricks.Config;

import java.awt.*;

public class GuiConfig {

    public final static Dimension FRAME_DIMENSION = new Dimension(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
    public final static Color BACKGROUND_COLOR = new Color(11, 3, 3);
    public final static Color FOREGROUND_COLOR = new Color(255, 255, 255);
    public final static Color BUTTON_COLOR = new Color(0, 153, 153);
    public final static Font DEFAULT_FONT = new Font("Comic Sans MS", Font.BOLD, 18);
    public final static Font BIG_FONT = DEFAULT_FONT.deriveFont(36.0F);
    public final static Font SMALL_FONT = DEFAULT_FONT.deriveFont(14.0F);
}
