package entity;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Car extends Element {

    public Car(int x, int y) {
        super(x, y);
        try {
            icon = ImageIO.read(getClass().getResourceAsStream("/images/car.png"));
            if (icon == null) System.out.println("Image stream is null!");
        } catch (IOException e) {
            e.printStackTrace();
            if (icon == null) System.out.println("Car image stream is null!");

        }
    }
}
