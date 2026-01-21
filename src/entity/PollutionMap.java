package entity;

import se.mau.DA343A.VT26.assignment1.IPollutionMap;
import se.mau.DA343A.VT26.assignment1.ImageProvider;

import java.awt.image.BufferedImage;

public class PollutionMap implements IPollutionMap {

    private final double width = 100;
    private final double height = 100;
    private final BufferedImage background;

    public PollutionMap(ImageProvider imageProvider) {
        this.background = imageProvider.getMapImage();
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
    public double getPollution(int x, int y) {
        return 0;
    }

    @Override
    public void setPollution(int x, int y, double value) {
    }

    @Override
    public BufferedImage getMapBackgroundImage() {
        return background;
    }
}
