package com.bricks;

import java.awt.*;

public class Brick extends Element {

    public static final int WIDTH = 50;
    public static final int HEIGHT = 20;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        color = Color.BLUE;
    }

    @Override
    protected Shape getShape() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
