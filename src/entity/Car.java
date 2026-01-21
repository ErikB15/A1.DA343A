package entity;

import java.awt.image.BufferedImage;
import se.mau.DA343A.VT26.assignment1.AirQualityGUI;
import se.mau.DA343A.VT26.assignment1.CompassDirection;
import se.mau.DA343A.VT26.assignment1.IGeographicFeatureMap;
import se.mau.DA343A.VT26.assignment1.MovedOutOfGridException;
import se.mau.DA343A.VT26.assignment1.IPollutionMap;


public class Car extends Element {

    public Car(int row, int column, BufferedImage icon, IGeographicFeatureMap geoMap, IPollutionMap pollutionMap) {
        super(row, column, icon, geoMap, pollutionMap);
    }

    @Override
    public void move() throws MovedOutOfGridException {
        CompassDirection[] directions = CompassDirection.values();
        CompassDirection dir = directions[(int)(Math.random() * directions.length)];

        int newRow = row;
        int newColumn = column;

        switch (dir) {
            case NORTH:
                newRow = newRow - 1;
                break;
            case SOUTH:
                newRow = newRow + 1;
                break;
            case WEST:
                newColumn = newColumn - 1;
                break;
            case EAST:
                newColumn = newColumn + 1;
                break;
        }

        if (newRow < 0 || newRow >= AirQualityGUI.GRID_SIZE || newColumn < 0 || newColumn >= AirQualityGUI.GRID_SIZE) {
            throw new MovedOutOfGridException();
        }
        if (!geoMap.isLand(newColumn, newRow)) {
            System.out.println("Car cannot drive on water");
            return;
        }

        row = newRow;
        column = newColumn;
    }

    @Override
    public void pollute() {
        double current = pollutionMap.getPollution(row, column);
        pollutionMap.setPollution(row, column, current + 5);
    }
}
