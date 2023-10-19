import bagel.*;
public class Note extends MovingObject{

    private Image img;
    private double yCoordinate;
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
            this.yCoordinate = 24.0;
            this.lastFrame = this.initialFrame + (int) Math.ceil(826.0/ speed.getYSpeed()); //default last frame for hold note
            this.img = new Image("res/holdNote" + this.noteDirection + ".png");
        } else if (row2.equals("Normal")){
            this.noteDirection = row1;
            this.initialFrame = Integer.parseInt(frame);
            this.noteType = "Normal";
            this.yCoordinate = 100.0;
            this.lastFrame = this.initialFrame + (int) Math.ceil(668.0/ speed.getYSpeed()); //default last frame
            this.img = new Image("res/note" + this.noteDirection + ".png");

        } else if(row2.equals("Bomb")){
            this.specialType = row2;
            this.noteDirection = row1;
            this.initialFrame = Integer.parseInt(frame);
            this.noteType = "Normal";
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

    public void draw(double x){
        img.draw(x, this.yCoordinate);
    }

    public void draw(){
        img.draw(500.0, this.yCoordinate);
    }
    public void update(String command){

    }

    public void updateCoordinate(int frame){
        this.yCoordinate += speed.getYSpeed();
    }
}


