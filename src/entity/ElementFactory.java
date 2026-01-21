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

    public Element createElement(String type, int x, int y) {

        return switch (type) {
            case "Car" -> {
                if (!geoMap.isLand(y, x)) {
                    yield null;
                }
                yield new Car(x, y, imageProvider.getCarImage());
            }
            case "Bus" -> {
                if (!geoMap.isLand(y, x)) {
                    yield null;
                }
                yield new Bus(x, y, imageProvider.getBusImage());
            }
            case "Airplane" -> {
                yield new Airplane(x, y, imageProvider.getAirPlaneImage());
            }
            default -> null;
        };
    }


}
