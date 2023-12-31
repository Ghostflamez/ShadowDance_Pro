import bagel.Image;

public class BombNote extends Note{
    protected static final double refY = 657.0;
    private Image img;
    private double xCoordinate;
    private Speed speed = new Speed(0,2.0);
    private String noteDirection;
    private int initialFrame;
    private int lastFrame;
    public String noteType;
    private String specialType;

    private boolean visibility = true;

    //constructor
    public BombNote (String row1, String row2, String initialFrame){
        super(row1, row2, initialFrame);
    }

    // Methods
    public boolean isTriggered() {
        double distance = Math.abs(this.yCoordinate - refY);
        if (distance <= 200.0) {
            return true;
        } else {
            return false;
        }
    }
}


