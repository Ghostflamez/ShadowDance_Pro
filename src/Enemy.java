import bagel.Image;

import java.lang.reflect.Array;

public class Enemy extends MovingObject {

    // Attributes
    public static final String FILEPATH;  // Initialize in static block or constructor
    private double xCoordinate;
    private double yCoordinate;
    private Speed speed;  // Assume there is a Speed class

    // Constructors
    // Implement constructors as required

    // Getter and Setter methods for xCoordinate and yCoordinate
    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    // Methods related to speed
    public void setSpeed(double xPos) {
        // Assume a method in Speed class that sets speed based on xPos
        speed.setSpeed(xPos,0);
    }

    public Speed getSpeed() {  // The return type is Array, but you may want to replace Array with an actual type
        // Assume a method in Speed class that gets speed
        return this.speed;
    }

    @Override
    public void setLastFrame(int lastFrame) {

    }

    @Override
    public void setImg() {

    }

    @Override
    public Image getImg() {
        return null;
    }

    // Static block or constructor to initialize FILEPATH
    static {
        // Example of initializing FILEPATH in a static block
        FILEPATH = "your/file/path";
    }
}
