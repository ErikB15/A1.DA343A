package entity;

import se.mau.DA343A.VT26.assignment1.IElement;
import se.mau.DA343A.VT26.assignment1.IGeographicFeatureMap;
import se.mau.DA343A.VT26.assignment1.IPollutionMap;
import se.mau.DA343A.VT26.assignment1.MovedOutOfGridException;

import java.awt.image.BufferedImage;

public abstract class Element implements IElement {
    protected int row;
    protected int column;
    protected BufferedImage icon;
    protected IGeographicFeatureMap geoMap;
    protected IPollutionMap pollutionMap;

    public Element(int row, int column, BufferedImage icon, IGeographicFeatureMap geoMap, IPollutionMap pollutionMap) {
        this.row = row;
        this.column = column;
        this.icon = icon;
        this.geoMap = geoMap;
        this.pollutionMap = pollutionMap;
    }

    public abstract void move()throws MovedOutOfGridException ;

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
