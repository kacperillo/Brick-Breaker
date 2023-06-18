package com.bricks.gui;

import com.bricks.Controller;

public class WinPanel extends EndGamePanel {


    public WinPanel(Controller controller) {
        super(controller);
        message.setText("Congratulation! You win!");
    }
}
