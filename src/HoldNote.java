import bagel.*;
public class HoldNote extends Note{

    // Attributes
    public static final double length = 82.0*2.0;
    private Image img;
    private double xCoordinate;
    private double yCoordinate = 24.0;
    private Speed speed = new Speed(0,2.0);
    private String noteDirection;
    private int initialFrame;
    private int lastFrame;
    public String noteType = "Hold";


    // Constructors
    public HoldNote(String row1, String row2, String initialFrame){
        super(row1, row2, initialFrame);
    }
    // Methods
}
