package entity;

import se.mau.DA343A.VT26.assignment1.*;

import java.awt.image.BufferedImage;

public class Woodland extends Element{

    public Woodland(int row, int column, BufferedImage icon, IGeographicFeatureMap geoMap, IPollutionMap pollutionMap) {
        super(row, column, icon, geoMap, pollutionMap);
    }

    @Override
    public void move() throws MovedOutOfGridException {}

    @Override
    public void pollute() {
        double current = pollutionMap.getPollution(row, column);
        double newValue = current - 5;
        if (newValue < 0) newValue = 0;
        pollutionMap.setPollution(row, column, newValue);
    }

}
