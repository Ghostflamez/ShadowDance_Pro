import bagel.*;
public class Message {

    // Attributes
    private static final String font = "res/FSO8BITR.TTF";
    private int fontSize;
    private Font fontOptions;
    private String text;
    private double xCoordinate;
    private double yCoordinate;

    private static final DrawOptions colour = (new DrawOptions()).setBlendColour(1.0, 1.0, 1.0);


    // Constructors
    public Message(int fontSize, String text, double xCoordinate, double yCoordinate) {
        this.fontSize = fontSize;
        this.text = text;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.fontOptions = new Font(font, this.fontSize);
    }

    // Methods
    public void draw() {
        this.fontOptions.drawString(this.text, this.xCoordinate, this.yCoordinate, colour);
    }
}
