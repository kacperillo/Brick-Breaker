package com.bricks;

import java.awt.*;

public abstract class Element {

    protected int x, y;
    protected Color color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void paint(Graphics2D g)  {
        g.setColor(color);
        g.fill(getShape());
    }

    protected abstract Shape getShape();

}
