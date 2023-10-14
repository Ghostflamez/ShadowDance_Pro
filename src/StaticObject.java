public abstract class StaticObject {

    // Constants
    public static final String FILEPATH;

    // Attributes
    public double xCoordinate;
    public double yCoordinate;

    // Constructor(s)
    public StaticObject() {
        // TODO: Initialize necessary attributes and operations if any
    }

    // Methods

    // Method to render the StaticObject
    public void render() {
        // Implement the method to render the StaticObject
    }

    // Getter for xCoordinate
    public double getXCoordinate() {
        return xCoordinate;
    }

    // Setter for xCoordinate
    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    // Getter for yCoordinate
    public double getYCoordinate() {
        return yCoordinate;
    }

    // Setter for yCoordinate
    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
