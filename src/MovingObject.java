import bagel.*;
public abstract class MovingObject extends StaticObject{

    // Constants

    private Image img;
    // Attributes
    private double xCoordinate;
    private double yCoordinate;
    private Speed speed = new Speed(0,0);
    private int initialFrame;
    private int lastFrame;

    // Constructors
    // Implement constructors as required

    // Methods

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(double xSpeed, double ySpeed) {
        this.speed = new Speed(xSpeed, ySpeed);
    }

    public int getInitialFrame() {
        return initialFrame;
    }

    public void setInitialFrame(int initialFrame) {
        this.initialFrame = initialFrame;
    }

    public int getLastFrame() {
        return lastFrame;
    }

    public abstract void setLastFrame(int lastFrame);

    public abstract void setImg();
    public abstract Image getImg();



}
