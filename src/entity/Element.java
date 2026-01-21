package entity;

import se.mau.DA343A.VT26.assignment1.IElement;
import java.awt.image.BufferedImage;

public abstract class Element implements IElement {
    protected int row;
    protected int column;
    protected BufferedImage icon;

    public Element(int row, int column, BufferedImage icon) {
        this.row = row;
        this.column = column;
        this.icon = icon;
    }

    public abstract void move();

    public abstract void pollute();
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public BufferedImage getIcon() {
        return icon;
    }
}
