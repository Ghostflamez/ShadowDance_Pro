import bagel.*;
public abstract class StaticObject {

    // Constants
    private Image img;

    // Attributes
    private double xCoordinate;
    private double yCoordinate;

    // Methods

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

    public abstract void setImg();
    public abstract Image getImg();
}
