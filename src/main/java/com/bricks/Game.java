package com.bricks;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Game {

    private List<Brick> bricks;
    private Ball ball;
    private Paddle paddle;
    private boolean gameFlag = false;
    private boolean paddleLeftMoveFlag = false;
    private boolean paddleRightMoveFlag = false;
    private Timer ballTimer, logicTimer;

    public Game() {
        initElements();
        start();
    }

    public void paint(Graphics2D g) {
        synchronized (this) {
            for (Brick brick : bricks)
                brick.paint(g);
        }
        ball.paint(g);
        paddle.paint(g);
    }

    public void setPaddleLeftMoveFlag(boolean b) {
        paddleLeftMoveFlag = b;
    }

    public void setPaddleRightMoveFlag(boolean b) {
        paddleRightMoveFlag = b;
    }

    private void initElements() {
        bricks = new ArrayList<>();
        for(int i = 0; i < Config.COLUMNS; i++) {
            for(int j = 0; j < Config.ROWS; j++) {
                bricks.add(new Brick(
                        10 + i * (Config.BRICK_WIDTH + Config.GAP),
                        j * (Config.BRICK_HEIGHT + Config.GAP)));
            }
        }
        ball = new Ball(200,300);
        paddle = new Paddle(300);
        logicTimer = new Timer();
        ballTimer = new Timer();
    }

    private void checkPaddleMove() {
        if(paddleLeftMoveFlag) {
            paddle.moveLeft();
        } else if(paddleRightMoveFlag) {
            paddle.moveRight();
        }
    }

    private synchronized void checkIntersects() {
        if(bricks.removeIf(
                element -> ball.checkIntersects(element)) || ball.checkIntersects(paddle)) {
            ball.changeYDirection();
        }
    }

    private void checkRebounds() {
        if(ball.getX() <= 0 || ball.getX() >= (500 - 2 * Config.BALL_R)) {
            ball.changeXDirection();
        }
        if(ball.getY() <= 0) {
            ball.changeYDirection();
        }
    }
    private void checkGameOver() {
        if(ball.getY() > Config.FRAME_HEIGHT) {
            logicTimer.cancel();
            ballTimer.cancel();
            gameFlag = false;
        }
    }

    private void updateGame() {
        checkPaddleMove();
        checkRebounds();
        checkIntersects();
        checkGameOver();
    }

    private void start() {
        gameFlag = true;

        logicTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateGame();
            }
        }, 0, Config.PERIOD);

        ballTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                ball.move();
            }
        }, 0, 8);
    }
}
