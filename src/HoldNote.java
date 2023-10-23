import bagel.*;
public class HoldNote extends Note{

    // Attributes
    private static final double refY = 657.0;
    public static final double length = 82.0*2.0;
    private Image img;

    private double yCoordinate = 24.0;
    private Speed speed = new Speed(0,2.0);
    private String noteDirection;
    private int initialFrame;
    private int lastFrame;
    public String noteType;


    // Constructors
    public HoldNote(String row1, String row2, String initialFrame){
        super(row1, row2, initialFrame);
    }
    // Methods

    @Override
    public String getMark() {
        return null;
    }

    @Override
    public int getScore() {
        return 0;
    }


    public int getUpperScore() {
        double distance = Math.abs(this.yCoordinate - this.length/2 - refY);
        if (distance <= 15) {
            return 10; // PERFECT
        } else if (distance <= 50) {
            return 5; // GOOD
        } else if (distance <= 100) {
            return -1; // BAD
        } else if (distance <= 200) {
            return -5; // MISS
        } else {
            return 0; //
        }
    }

    public int getLowerScore() {
        double distance = Math.abs(this.yCoordinate + this.length/2 - refY);
        if (distance <= 15) {
            return 10; // PERFECT
        } else if (distance <= 50) {
            return 5; // GOOD
        } else if (distance <= 100) {
            return -1; // BAD
        } else if (distance <= 200) {
            return -5; // MISS
        } else {
            return 0; //
        }
    }

    public String getUpperMark() {
        double distance = Math.abs(this.yCoordinate - this.length/2 - refY);
        if (distance <= 15) {
            return  "PERFECT";
        } else if (distance <= 50) {
            return "GOOD";
        } else if (distance <= 100) {
            return "BAD";
        } else if (distance <= 200) {
            return "MISS";
        } else {
            return "";
        }
    }

    public String getLowerMark() {
        double distance = Math.abs(this.yCoordinate + this.length/2 - refY);
        if (distance <= 15) {
            return  "PERFECT";
        } else if (distance <= 50) {
            return "GOOD";
        } else if (distance <= 100) {
            return "BAD";
        } else if (distance <= 200) {
            return "MISS";
        } else {
            return "";
        }
    }

}
