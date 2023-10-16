import bagel.Image;

public class BombNote extends Note{
    private Image img;
    private double xCoordinate;
    private double yCoordinate = 100.0;
    private Speed speed = new Speed(0,2.0);
    private String noteDirection;
    private int initialFrame;
    private int lastFrame;
    public String noteType = "Normal";
    private String specialType;

    private boolean visibility = true;

    //constructor
    public BombNote (String row1, String row2, String initialFrame){
        super(row1, row2, initialFrame);
    }
}


