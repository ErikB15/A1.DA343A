package view;

import controller.Controller;
import se.mau.DA343A.VT26.assignment1.AirQualityGUI;
import se.mau.DA343A.VT26.assignment1.IElement;
import se.mau.DA343A.VT26.assignment1.IPollutionMap;

import java.util.ArrayList;
import java.util.List;

public class AirGui extends AirQualityGUI {
    Controller controller;

    public AirGui(String[] elementSelectorTypeNames, IPollutionMap pollutionMap, Controller controller) {
        super(elementSelectorTypeNames, pollutionMap);
        this.controller = controller;
    }

    @Override
    protected void mouseClickedOnMap(int x, int y) {
        String selectedType = getSelectedElementTypeLabel();
        controller.handleMapClick(x, y, selectedType);
        repaint();
    }


    @Override
    protected void buttonNextTimeStepClicked() {

    }

    @Override
    protected List<IElement> provideElementIconsToPaint() {
        return new ArrayList<>(controller.getElements());
    }










}
