package entity;

public class ElementFactory {
    public Element createElement(String typeOfElement, int x, int y) {

        switch (typeOfElement) {

            case "Car":
                return new Car(x, y);
            default:
                return null;
        }
    }
}