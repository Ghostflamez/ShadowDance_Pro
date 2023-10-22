import bagel.Image;

public class Lane extends StaticObject{


    // Attributes

    private Image img;
    private double xCoordinate;
    private static final double yCoordinate = 384.0;
    private String laneType;

    // Constructor
    public Lane(String type, String xCoordinate) {
        this.laneType = type;
        this.img = new Image("res/lane" + this.laneType + ".png");
        this.xCoordinate = Double.parseDouble(xCoordinate);
    }

    // Methods

    public String getLaneType() {
        return laneType;
    }

    @Override
    public void setYCoordinate(double yCoordinate){
        System.out.print("Lane yCoordinate cannot be set");
    }
    @Override
    public void setImg(){
        this.img = new Image("res/lane" + this.getLaneType() + ".png");
    };
    @Override
    public Image getImg(){return img;}

    public void draw() {
        this.img.draw(this.xCoordinate, yCoordinate);
    }



}
