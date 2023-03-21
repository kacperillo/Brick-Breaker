package com.bricks;

import java.awt.*;

public class Brick extends Element {

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        color = Config.BRICK_COLOR;
    }

    @Override
    protected Shape getShape() {
        return new Rectangle(x, y, Config.BRICK_WIDTH, Config.BRICK_HEIGHT);
    }

    @Override
    protected int getWidth() {
        return Config.BRICK_WIDTH;
    }

    @Override
    protected int getHeight() {
        return Config.BRICK_HEIGHT;
    }
}
