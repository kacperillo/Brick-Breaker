package com.bricks;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball extends Element {

    public static final int R = 10;
    private final int d = 5;
    private double dx;
    private double dy;


    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        color = Color.BLACK;
        dx = -2;
        dy = -2;
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
        return getShape().intersects((Rectangle)element.getShape());
    }

    @Override
    protected Shape getShape() {
        return new Ellipse2D.Double(x, y, R, R);
    }
}
