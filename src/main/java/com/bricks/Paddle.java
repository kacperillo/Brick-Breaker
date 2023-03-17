package com.bricks;

import java.awt.*;

public class Paddle extends Element {

    private final int width;
    private final int height;
    private final int dx = Config.PADDLE_SPEED;

    public Paddle(int x) {
        this.x = x;
        y = 420;
        color = Config.PADDLE_COLOR;
        width = Config.PADDLE_WIDTH;
        height = Config.PADDLE_HEIGHT;
    }

    public void moveRight() {
        x += dx;
        if(x > 500 - width) x = 500 - width;
    }

    public void moveLeft() {
        x -= dx;
        if(x < 0) x = 0;
    }

    @Override
    protected Shape getShape() {
        return new Rectangle(x, y, width, height);
    }
}
