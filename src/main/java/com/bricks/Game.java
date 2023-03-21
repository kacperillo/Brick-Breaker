package com.bricks;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Game {

    private Controller controller;
    private List<Brick> bricks;
    private Ball ball;
    private Paddle paddle;
    private boolean paddleLeftMoveFlag = false;
    private boolean paddleRightMoveFlag = false;
    private Timer timer;

    public Game(Controller controller) {
        this.controller = controller;
        initElements();
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
                        Config.GAP + i * (Config.BRICK_WIDTH + Config.GAP),
                        Config.GAP + j * (Config.BRICK_HEIGHT + Config.GAP)));
            }
        }
        ball = new Ball(200,300);
        paddle = new Paddle(300);
        timer = new Timer();
    }

    private void checkPaddleMove() {
        if (paddleLeftMoveFlag) {
            paddle.moveLeft();
        } else if (paddleRightMoveFlag) {
            paddle.moveRight();
        }
    }

    private synchronized void checkIntersectsWithBricks() {
        for (Brick brick : bricks) {
            if (ball.checkHorizontalIntersects(brick)) {
                ball.changeYDirection();
                bricks.remove(brick);
                break;
            }
            if (ball.checkVerticalIntersects(brick)) {
                ball.changeXDirection();
                if (!ball.isFalling())
                    ball.changeYDirection();
                bricks.remove(brick);
                break;
            }
        }
    }

    private void checkIntersectsWithPaddle() {
        if (ball.checkHorizontalIntersects(paddle)) {
            ball.changeYDirection();
        } else if (ball.checkVerticalIntersects(paddle)) {
            ball.changeXDirection();
        }
    }

    private void checkRebounds() {
        if (ball.getX() <= 0 || ball.getX() >= (Config.FRAME_WIDTH - ball.getWidth())) {
            ball.changeXDirection();
        }
        if (ball.getY() <= 0) {
            ball.changeYDirection();
        }
    }
    private void checkGameOver() {
        if(ball.getY() > Config.FRAME_HEIGHT) {
            timer.cancel();
            controller.stopGame();
        }
    }

    private void updateGame() {
        checkPaddleMove();
        checkRebounds();
        if (ball.getY() < Config.FRAME_HEIGHT / 2) {
            checkIntersectsWithBricks();
        } else {
            checkIntersectsWithPaddle();
        }
        checkGameOver();
        ball.move();
    }

    public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateGame();
            }
        }, 0, Config.PERIOD);

    }
}
