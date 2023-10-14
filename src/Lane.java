public class Lane extends StaticObject{

    // Attributes
    public static final String FILEPATH;
    public static final double refY = 657;
    private double xCoordinate;
    private double yCoordinate;
    public String laneType;

    // Constructors
    // Implement constructors as required

    // Methods
    public void setYCoordinate(double yPos) {
        yCoordinate = yPos;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public double getRefY() {
        return refY;
    }

    public void render() {
        // Implement the render logic
    }
}
