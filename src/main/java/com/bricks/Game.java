package com.bricks;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Game {

    private static final int period = 20;
    public static final int numberOfColumns = 8;
    public static final int numberOfRows = 4;
    private static final int gapBetweenBricks = 10;

    private List<Brick> bricks;
    private Ball ball;
    private Paddle paddle;
    private boolean gameFlag = false;
    private boolean paddleLeftMoveFlag = false;
    private boolean paddleRightMoveFlag = false;
    private Timer timer;

    public Game() {
        initElements();
        start();
    }

    private void initElements() {
        bricks = new ArrayList<>();
        for(int i = 0; i < numberOfColumns; i++) {
            for(int j = 0; j < numberOfRows; j++) {
                bricks.add(new Brick(10 + i*(Brick.WIDTH + gapBetweenBricks), j*(Brick.HEIGHT + gapBetweenBricks)));
            }
        }
        Random random = new Random();
        ball = new Ball(200,300);
        paddle = new Paddle(300);
    }

    private void checkPaddleMove() {
        if(paddleLeftMoveFlag) paddle.moveLeft();
        else if(paddleRightMoveFlag) paddle.moveRight();
    }

    private void checkIntersects() {
        if(bricks.removeIf(element -> ball.checkIntersects(element)) || ball.checkIntersects(paddle))
            ball.changeYDirection();
    }

    private void checkRebounds() {
        if(ball.getX() <= 0 || ball.getX() >= (500 - 2*Ball.R)) {
            ball.changeXDirection();
        }
        if(ball.getY() <= 0)
            ball.changeYDirection();
    }
    private void checkGameOver() {
        if(ball.getY() > BrickBreakerApp.HEIGHT) {
            timer.cancel();
            gameFlag = false;
            System.out.println("game over");
        }
    }

    private void update() {
        checkPaddleMove();
        checkRebounds();
        checkIntersects();
        checkGameOver();
    }

    private void start() {
        gameFlag = true;
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, period);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ball.move();
            }
        }, 0, 8);
    }

    public void paint(Graphics2D g) {
        for(Brick brick : bricks)
            brick.paint(g);
        ball.paint(g);
        paddle.paint(g);
    }

    public void setPaddleLeftMoveFlag(boolean b) {
        paddleLeftMoveFlag = b;
    }

    public void setPaddleRightMoveFlag(boolean b) {
        paddleRightMoveFlag = b;
    }
}
