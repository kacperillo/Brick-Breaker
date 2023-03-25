package com.bricks;

import com.bricks.gui.Gui;

import java.awt.*;

public class Controller {

    private Game game;
    private final Gui gui;

    public Controller() {
        gui = new Gui(this);
    }

    public void startGame() {
        game = new Game(this);
        game.start();
        gui.startDrawingGame();
    }

    public void stopGame() {
        gui.stopGame();
    }

    public void paintGame(Graphics g) {
        game.paint(g);
    }

    public void setPaddleLeftMoveFlag(boolean b) {
        game.setPaddleLeftMoveFlag(b);
    }

    public void setPaddleRightMoveFlag(boolean b) {
        game.setPaddleRightMoveFlag(b);
    }

    public void backToStart() {
        gui.backToMainMenu();
    }
}
