package controller;

import entity.ElementFactory;
import entity.PollutionMap;
import se.mau.DA343A.VT26.assignment1.*;
import view.*;

/**
 * Fuck denna uppgift helt ärligt. were we left off: det finns metoder som inte behövs,
 * målet med det vi försöker göra är att när användaren trycker poå mappen ska det synas en bil.
 *
 * Läs uppgiftsbeskrivning. efter bilen är synlig så se hur du kan få den att visa polution och allt sånt.
 * poängen med uppgiften är inte att lösa den, utan att faktisikt lära siug skapa ngt från greunden själv. läs doc i klasserna och försöööök arbeta från det
 */


public class Main {

    public static void main(String[] args) {
        ImageProvider imageProvider = new ImageProvider();
        PollutionMap pollutionMap = new PollutionMap(imageProvider);

        GeographicFeatureMapBuilder builder = new GeographicFeatureMapBuilder();
        builder.setHeight(AirQualityGUI.GRID_SIZE);
        builder.setWidth(AirQualityGUI.GRID_SIZE);
        IGeographicFeatureMap geoMap = builder.build();

        ElementFactory factory = new ElementFactory(imageProvider, geoMap, pollutionMap);
        Controller controller = new Controller(pollutionMap, factory, imageProvider);
        String[] elementSelectorTypeNames = {"Car", "Bus", "Airplane", "Bike", "Woodland"};

        AirGui airgui = new AirGui(elementSelectorTypeNames, pollutionMap, controller);
        airgui.startGUIOnNewGUIThread();
    }
}
