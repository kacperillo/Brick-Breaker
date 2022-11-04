package com.bricks;

import java.awt.*;

public class Paddle extends Element {

    public static final int WIDTH = 70;
    public static final int HEIGHT = 10;
    private final int dx = 4;

    public Paddle(int x) {
        this.x = x;
        y = 420;
        color = Color.RED;
    }

    public void moveRight() {
        x += dx;
        if(x > 500 - WIDTH) x = 500 - WIDTH;
    }

    public void moveLeft() {
        x -= dx;
        if(x < 0) x = 0;
    }

    @Override
    protected Shape getShape() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
