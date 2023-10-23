import bagel.Image;
import java.util.Random;
import java.lang.reflect.Array;

public class Enemy extends MovingObject {

    // Attributes
    public static final String FILEPATH = "res/enemy.png";  // Initialize in static block or constructor
    private double xCoordinate;
    private double yCoordinate;
    private Speed speed;  // Assume there is a Speed class
    private Image img;
    private int initialFrame;


    // Constructors
    // Implement constructors as required
    public Enemy(int frame) {
        Random random = new Random();
        this.xCoordinate = random.nextInt(801) + 100;  // Random value between 100 and 900
        this.yCoordinate = random.nextInt(401) + 100;  // Random value between 100 and 500
        int speedDirection = random.nextBoolean() ? 1 : -1;  // Random value of either 1 or -1
        Speed speed = new Speed(speedDirection, 0.0);  // Default speed
        this.speed = speed;
        this.img = new Image(FILEPATH);
        this.initialFrame = frame;
    }

    // update() method
    public void update() {
            this.move();
    }

    private void move(){
        this.xCoordinate += this.speed.getXSpeed();
        if (this.xCoordinate < 100 || this.xCoordinate > 900) {
            this.speed.reverseSpeed();
        }
    }

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
    public void reverseSpeed() {
        // Assume a method in Speed class that sets speed based on xPos
        this.speed.reverseSpeed();
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
        return this.img;
    }

    // draw() method
    public void draw() {
        this.img.draw(this.xCoordinate, this.yCoordinate);
    }
}
