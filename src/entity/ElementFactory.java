package entity;

import se.mau.DA343A.VT26.assignment1.ImageProvider;
import se.mau.DA343A.VT26.assignment1.IGeographicFeatureMap;
import se.mau.DA343A.VT26.assignment1.IPollutionMap;

public class ElementFactory {

    private final ImageProvider imageProvider;
    private final IGeographicFeatureMap geoMap;
    private final IPollutionMap pollutionMap;

    public ElementFactory(ImageProvider imageProvider, IGeographicFeatureMap geoMap, IPollutionMap pollutionMap) {
        this.imageProvider = imageProvider;
        this.geoMap = geoMap;
        this.pollutionMap = pollutionMap;
    }

    public Element createElement(String typeOfElement, int x, int y) {

        return switch (typeOfElement) {
            case "Car" -> {
                if (!geoMap.isLand(x, y)) {
                    System.out.println("A car cannot exist on water");
                    yield null;
                }
                yield new Car(x, y, imageProvider.getCarImage(), geoMap, pollutionMap);
            }
            case "Bus" -> {
                if (!geoMap.isLand(x, y)) {
                    System.out.println("A bus cannot exist on water");
                    yield null;
                }
                yield new Bus(x, y, imageProvider.getBusImage(), geoMap, pollutionMap);
            }
            case "Bike" -> {
                if (!geoMap.isLand(x, y)) {
                    System.out.println("A Bike cannot exist on water");
                    yield null;
                }
                yield new Bike(x, y, imageProvider.getBikeImage(), geoMap, pollutionMap);
            }
            case "Woodland" -> {
                if (!geoMap.isLand(x, y)) {
                    System.out.println("Trees cannot exist on water");
                    yield null;
                }
                yield new Woodland(x, y, imageProvider.getTreesImage(), geoMap, pollutionMap);
            }
            case "Airplane" -> new Airplane(x, y, imageProvider.getAirPlaneImage(), geoMap, pollutionMap);
            default -> null;
        };
    }


}
