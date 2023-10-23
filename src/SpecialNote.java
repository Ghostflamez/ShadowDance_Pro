import bagel.*;
public class SpecialNote extends Note{
    // Constants
    private static final double refY = 657.0;
    private Image img;
    private double xCoordinate;
    private double initialyCoordinate;
    private Speed speed = new Speed(0,2.0);
    private int initialFrame;
    private int lastFrame;
    public String noteType;

    // Constructor(s)
    public SpecialNote(String row1, String row2, String frame){
        super(row1, row2, frame);
    }

    // Methods

    // Getter for specialType


    public boolean isTriggered() {
        double distance = Math.abs(this.yCoordinate - refY);
        System.out.println("yCoordinate: " + this.yCoordinate);
        System.out.println("Distance: " + distance);
        if (distance <= 200) {
            return true;
        } else {
            return false;
        }
    }
}

