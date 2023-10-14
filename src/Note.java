public class Note extends MovingObject{

    public static final String FILEPATH = "";
    public static final String type = "Normal";
    private double xCoordinate;
    private double yCoordinate;
    private Speed speed;
    private String noteDirection;
    private int initialFrame;
    private int lastFrame;


    public void setSpeed(Speed defaultSpeed) {

    }

    public Object[] getSpeed() {  // 注意：返回类型是Object[]，具体应根据实际情况调整

        return null;
    }

    public void update() {

    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public String getDirection() {
        return noteDirection;
    }

    public int getInitialFrame() {
        return initialFrame;
    }

    public int getLastFrame() {
        return lastFrame;
    }

    public String getType() {
        return type;
    }

    public void setXCoordinate(double XPos) {

    }

    public void setYCoordinate(double YPos) {

    }

    public void setDirection(String direction) {

    }

    public void setInitialFrame() {

    }

    public void setLastFrame() {

    }
}


