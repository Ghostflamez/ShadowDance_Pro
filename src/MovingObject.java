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

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public static boolean isCollided(MovingObject movingObject1, MovingObject movingObject2){
        double distance = Math.sqrt(Math.pow(movingObject1.getXCoordinate() - movingObject2.getXCoordinate(), 2) + Math.pow(movingObject1.getYCoordinate() - movingObject2.getYCoordinate(), 2));
        if (distance <= 104.0){
            return true;
        } else {
            return false;
        }
    }


}
