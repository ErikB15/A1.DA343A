package entity;

import java.awt.image.BufferedImage;

public abstract class Element {

    protected int x;
    protected int y;
    protected BufferedImage icon;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getIcon() {
        return icon;
    }
}
