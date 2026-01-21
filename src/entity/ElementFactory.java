package entity;

import se.mau.DA343A.VT26.assignment1.ImageProvider;
import se.mau.DA343A.VT26.assignment1.IGeographicFeatureMap;

public class ElementFactory {

    private final ImageProvider imageProvider;
    private final IGeographicFeatureMap geoMap;

    public ElementFactory(ImageProvider imageProvider, IGeographicFeatureMap geoMap) {
        this.imageProvider = imageProvider;
        this.geoMap = geoMap;
    }

    public Element createElement(String typeOfElement, int x, int y) {

        return switch (typeOfElement) {
            case "Car" -> {
                if (!geoMap.isLand(x, y)) {
                    System.out.println("A car connot exist on water");
                    yield null;
                }
                yield new Car(x, y, imageProvider.getCarImage());
            }
            case "Bus" -> {
                if (!geoMap.isLand(x, y)) {
                    System.out.println("A bus connot exist on water");
                    yield null;
                }
                yield new Bus(x, y, imageProvider.getBusImage());
            }
            case "Airplane" -> new Airplane(x, y, imageProvider.getAirPlaneImage());
            default -> null;
        };
    }


}
