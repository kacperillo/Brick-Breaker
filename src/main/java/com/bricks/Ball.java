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

    public void changeXDirection() {
        dx = -dx;
    }

    public void changeYDirection() {
        dy = -dy;
    }

    public boolean checkIntersects(Element element) {
        return this.getShape().intersects(
                (Rectangle) element.getShape());
    }

    @Override
    protected Shape getShape() {
        return new Ellipse2D.Double(x, y, Config.BALL_R, Config.BALL_R);
    }
}
