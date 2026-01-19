package entity;

import se.mau.DA343A.VT26.assignment1.IPollutionMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PollutionMap implements IPollutionMap {
    private final double width = 100;
    private final double height = 100;
    private final double[][] data;
    private final BufferedImage background;

    public PollutionMap() {
        data = new double[100][100];

        BufferedImage tempImg;
        try {
            tempImg = ImageIO.read(getClass().getResourceAsStream("/images/malmo.png"));
        } catch (IOException e) {
            e.printStackTrace();
            tempImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        }

        background = tempImg;
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
        return data[x][y];
    }

    @Override
    public void setPollution(int x, int y, double value) {
        data[x][y] = value;
    }

    @Override
    public BufferedImage getMapBackgroundImage() {
        return background;
    }
}
