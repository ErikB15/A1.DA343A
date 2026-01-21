package view;

import controller.Controller;
import entity.Element;

import entity.PollutionMap;
import se.mau.DA343A.VT26.assignment1.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AirGui extends AirQualityGUI {
    private final Controller controller;
    private final PollutionMap pollutionMap;

    public AirGui(String[] elementSelectorTypeNames, PollutionMap pollutionMap, Controller controller) {
        super(elementSelectorTypeNames, pollutionMap);
        this.controller = controller;
        this.pollutionMap = pollutionMap;
    }

    @Override
    protected void mouseClickedOnMap(int x, int y) {
        controller.handleMapClick(x, y, getSelectedElementTypeLabel());
        repaint();
    }

    @Override
    protected void buttonNextTimeStepClicked() {
        Iterator<Element> it = controller.getElements().iterator();

        while (it.hasNext()) {
            Element e = it.next();
            try {
                e.pollute();
                e.move();
            } catch (MovedOutOfGridException ex) {
                System.out.println("Vehicle cannot move outside the map and will now be destroyed: " + e);
                it.remove();
            }
        }
        pollutionMap.diffuse();
        repaint();
    }


    @Override
    protected List<IElement> provideElementIconsToPaint() {
        return new ArrayList<>(controller.getElements());
    }
}