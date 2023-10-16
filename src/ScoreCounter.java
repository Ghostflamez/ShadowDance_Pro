import bagel.Font;

public class ScoreCounter extends Message{

    // Attributes
    // Attributes
    private static final String font = "res/FSO8BITR.TTF";
    private int fontSize;
    private Font fontOptions;
    private String text;
    private double xCoordinate;
    private double yCoordinate;

    // Constructors
    public ScoreCounter(int fontSize, String text, double xCoordinate, double yCoordinate, double[] colour) {
        super(fontSize, text, xCoordinate, yCoordinate, colour);
    }
    // Methods

    public void addScore(int frameScore) {
        // Implement the logic to add score
    }

    public void drawString() {
        // Implement the logic for drawing the string
    }

    // Getters and setters
    // Implement getters and setters for the attributes

}
