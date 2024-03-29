package com.bricks;

import com.bricks.gui.Gui;

import java.awt.*;

public class Controller {

    private Game game;
    private final Gui gui;
    private boolean isPaused = false;

    public Controller() {
        gui = new Gui(this);
    }

    public void startGame() {
        game = new Game(this);
        game.start();
        gui.startDrawingGame();
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

    public void win() {
        gui.endGame(true);
    }

    public void loose() {
        gui.endGame(false);
    }

    public void pause(boolean showPausePanel) {
        isPaused = true;
        if (showPausePanel) {
            gui.pauseGame();
        }
    }

    public void resume() {
        isPaused = false;
        gui.resumeGame();
    }

    public boolean isPaused() {
        return isPaused;
    }
}
