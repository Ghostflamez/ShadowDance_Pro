import bagel.*;
public class SpecialNote extends Note{
    // Constants
    private Image img;
    private double yCoordinate;
    private Speed speed = new Speed(0,2.0);
    private int initialFrame;
    private int lastFrame;
    public String noteType = "Special";
    private String specialType;

    // Constructor(s)
    public SpecialNote(String row1, String row2, String initialFrame){
        super(row1, row2, initialFrame);
    }

    // Methods

    // Getter for specialType
    public String getSpecialType() {
        return specialType;
    }
}

