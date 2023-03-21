package com.bricks;

import com.bricks.gui.Gui;

import java.awt.*;

public class Controller {

    private Game game;
    private Gui gui;

    public void setGame(Game game) {
        this.game = game;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void startGame() {
        game.start();
    }

    public void stopGame() {
        gui.stopGame();
    }

    public void paintGame(Graphics2D g) {
        game.paint(g);
    }

    public void setPaddleLeftMoveFlag(boolean b) {
        game.setPaddleLeftMoveFlag(b);
    }

    public void setPaddleRightMoveFlag(boolean b) {
        game.setPaddleRightMoveFlag(b);
    }
}
