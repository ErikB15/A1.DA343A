package entity;

import se.mau.DA343A.VT26.assignment1.*;

import java.awt.image.BufferedImage;

public class PollutionMap implements IPollutionMap {

    private final int width = AirQualityGUI.GRID_SIZE;
    private final int height = AirQualityGUI.GRID_SIZE;

    private final double[][] pollutionGrid;
    private final ImageProvider imageProvider;

    public PollutionMap(ImageProvider imageProvider) {
        this.imageProvider = imageProvider;
        pollutionGrid = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pollutionGrid[i][j] = 0.0;
            }
        }
    }

    @Override
    public double getPollution(int row, int col) {
        if (row < 0 || row >= height || col < 0 || col >= width) return 0.0;
        return pollutionGrid[row][col];
    }

    @Override
    public void setPollution(int row, int col, double pollution) {
        if (row < 0 || row >= height || col < 0 || col >= width) return;
        if (pollution < 0) pollution = 0;
        pollutionGrid[row][col] = pollution;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public BufferedImage getMapBackgroundImage() {
        return imageProvider.getMapImage();
    }

    public void diffuse() {
        double[][] newGrid = new double[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                double sum = pollutionGrid[row][col];
                int count = 1;

                if (row > 0) { sum += pollutionGrid[row - 1][col]; count++; }
                if (row < height - 1) { sum += pollutionGrid[row + 1][col]; count++; }
                if (col > 0) { sum += pollutionGrid[row][col - 1]; count++; }
                if (col < width - 1) { sum += pollutionGrid[row][col + 1]; count++; }

                newGrid[row][col] = sum / count;
            }
        }

        for (int i = 0; i < height; i++) {
            System.arraycopy(newGrid[i], 0, pollutionGrid[i], 0, width);
        }
    }
}
