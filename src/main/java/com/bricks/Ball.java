package com.bricks;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball extends Element {

    private double dx;
    private double dy;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        color = Config.BALL_COLOR;
        dx = Config.BALL_SPEED;
        dy = Config.BALL_SPEED;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public boolean isFalling() {
        return dy > 0;
    }

    public void changeXDirection() {
        dx = -dx;
    }

    public void changeYDirection() {
        dy = -dy;
    }

    public boolean checkHorizontalIntersects(Element element) {
        return x + Config.BALL_R >= element.getX() &&
               x - Config.BALL_R <= element.getX() + element.getWidth() &&
               ((y + 1.5 * Config.BALL_R >= element.getY() &&
                       y < element.getY()) ||
               (y + getHeight() > element.getY() + element.getHeight() &&
                       y + 0.25 * Config.BALL_R < element.getY() + element.getHeight()));
    }

    public boolean checkVerticalIntersects(Element element) {
        return y + Config.BALL_R >= element.getY() &&
               y - Config.BALL_R <= element.getY() + element.getHeight() &&
               ((x + 1.75 * Config.BALL_R >= element.getX() &&
                       x < element.getX()) ||
               (x + getWidth() > element.getX() + element.getWidth() &&
                       x + 0.25 * Config.BALL_R < element.getX() + element.getWidth()));
    }

    @Override
    protected Shape getShape() {
        return new Ellipse2D.Double(x, y, Config.BALL_R, Config.BALL_R);
    }

    @Override
    protected int getWidth() {
        return 2*Config.BALL_R;
    }

    @Override
    protected int getHeight() {
        return 2*Config.BALL_R;
    }
}
