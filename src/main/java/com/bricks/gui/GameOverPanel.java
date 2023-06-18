package com.bricks.gui;

import com.bricks.Controller;

public class GameOverPanel extends EndGamePanel {


    public GameOverPanel(Controller controller) {
        super(controller);
        message.setText("Game Over :C Try again!");
    }
}