import bagel.*;
public class Note extends MovingObject{

    protected static final double refY = 657.0;
    private Image img;
    private double yCoordinate;
    private double xCoordinate;
    private double initialyCoordinate;
    private Speed speed = new Speed(0,2.0); //default speed
    private String noteDirection;
    private int initialFrame;
    private int lastFrame;
    public String noteType;
    private String specialType;


    private boolean visibility = true;

    //constructor
    public Note (String row1, String row2, String frame){
        if (row1.equals("Special")){
            this.specialType = row2;
            this.initialFrame = Integer.parseInt(frame);
            this.noteType = "Special";
            this.initialyCoordinate = 100.0;
            this.yCoordinate = 100.0;
            this.lastFrame = this.initialFrame + (int) Math.ceil(668.0/ speed.getYSpeed()); //default last frame
            if (this.specialType.equals("DoubleScore")) {
                this.img = new Image("res/note2x.png");
            } else {
                this.img = new Image("res/note" + this.specialType + ".png");
            }
        } else if (row2.equals("Hold")){
            this.noteDirection = row1;
            this.initialFrame = Integer.parseInt(frame);
            this.noteType = "Hold";
            this.initialyCoordinate = 24.0;
            this.yCoordinate = 24.0;
            this.lastFrame = this.initialFrame + (int) Math.ceil(826.0/ speed.getYSpeed()); //default last frame for hold note
            this.img = new Image("res/holdNote" + this.noteDirection + ".png");
        } else if (row2.equals("Normal")){
            this.noteDirection = row1;
            this.initialFrame = Integer.parseInt(frame);
            this.noteType = "Normal";
            this.initialyCoordinate = 100.0;
            this.yCoordinate = 100.0;
            this.lastFrame = this.initialFrame + (int) Math.ceil(668.0/ speed.getYSpeed()); //default last frame
            this.img = new Image("res/note" + this.noteDirection + ".png");

        } else if(row2.equals("Bomb")){
            this.specialType = row2;
            this.noteDirection = row1;
            this.initialFrame = Integer.parseInt(frame);
            this.noteType = "Normal";
            this.initialyCoordinate = 100.0;
            this.yCoordinate = 100.0;
            this.lastFrame = this.initialFrame + (int) Math.ceil(668.0/ speed.getYSpeed()); //default last frame
            this.img = new Image("res/noteBomb.png");
        }

    }
    //methods
    public int getInitialFrame() {
        return initialFrame;
    }

    public int getLastFrame() {
        return lastFrame;
    }

    public String getDirection() {
        return noteDirection;
    }


    public String getType() {
        return noteType;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setDirection(String direction) {
        this.noteDirection = direction;
    }

    @Override
    public void setLastFrame(int lastFrame) {
        this.lastFrame = lastFrame;
    }

    @Override
    public void setImg() {
        System.out.println("Note img cannot be set");
    }

    @Override
    public Image getImg(){
        return img;
    }



    public void draw(){
        img.draw(this.xCoordinate, this.yCoordinate);
    }
    public void update(String command){
        switch (command){
            case "SpeedUp":
                this.speed.speedUp();
                break;
            case "SpeedDown":
                this.speed.speedDown();
                break;
        }
    }

    public void updateCoordinate(int frame){
        this.yCoordinate = this.initialyCoordinate + speed.getYSpeed() * (frame - this.initialFrame);
    }
    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public int getScore() {
        double distance = Math.abs(this.yCoordinate - refY);
        if (distance <= 15) {
            return 10; // PERFECT
        } else if (distance <= 50) {
            return 5; // GOOD
        } else if (distance <= 100) {
            return -1; // BAD
        } else if (distance <= 200) {
            return -5; // MISS
        } else {
            return 0; // 或其他默认得分
        }
    }

    public String getMark() {
        double distance = Math.abs(this.yCoordinate - refY);
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


