import bagel.*;
public class Message {

    // Attributes
    private static final String font = "res/FSO8BITR.TTF";
    private int fontSize;
    private Font fontOptions;
    private String text;
    private double xCoordinate;
    private double yCoordinate;

    private DrawOptions colour = (new DrawOptions()).setBlendColour(1.0, 1.0, 1.0);


    // Constructors
    public Message(int fontSize, String text, double xCoordinate, double yCoordinate, double[] colour) {
        this.fontSize = fontSize;
        this.fontOptions = new Font(this.font, fontSize);
        this.text = text;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.colour = (new DrawOptions()).setBlendColour(colour[0], colour[1], colour[2]);
    }

    // Methods
    public void draw() {
        this.fontOptions.drawString(this.text, this.xCoordinate, this.yCoordinate, this.colour);
    }
}
