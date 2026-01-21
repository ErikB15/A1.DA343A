package controller;

import entity.Element;
import entity.ElementFactory;
import se.mau.DA343A.VT26.assignment1.IPollutionMap;
import se.mau.DA343A.VT26.assignment1.ImageProvider;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final List<Element> elements = new ArrayList<>();
    private ElementFactory factory;
    private IPollutionMap pollutionMap;
    private String selectedType;
    private ImageProvider imageProvider;



    public Controller(IPollutionMap pollutionMap, ElementFactory factory, ImageProvider imageProvider){
        this.pollutionMap = pollutionMap;
        this.factory = factory;
        this.imageProvider = imageProvider;
    }


    public void handleMapClick(int X, int Y, String selectedType) {
        Element newElement = factory.createElement(selectedType, X, Y);
        if (newElement != null) {
            elements.add(newElement);
        }
    }

    public List<Element> getElements() {
        return elements;
    }
}
