public class Speed {

    // Attributes
    private double xSpeed; //X coordinate increment of each frame
    private double ySpeed; //Y coordinate increment of each frame

    // Constructors
    // Implement constructors as required

    // Getter and Setter methods for xSpeed and ySpeed
    public Speed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

}
