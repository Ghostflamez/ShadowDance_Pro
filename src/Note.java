import bagel.*;
public class Note extends MovingObject{

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
    public Note (String row1, String row2, String initialFrame){
        if (row1.equals("Special")){
            this.specialType = row2;
            this.initialFrame = Integer.parseInt(initialFrame);
            this.lastFrame = this.initialFrame + (int) Math.ceil(668.0/ speed.getYSpeed());
            this.img = new Image("res/note" + this.specialType + ".png");
        } else if (row2.equals("Hold")){
            this.noteDirection = row1;
            this.initialFrame = Integer.parseInt(initialFrame);
            this.lastFrame = this.initialFrame + (int) Math.ceil(826.0/ speed.getYSpeed());
            this.img = new Image("res/holdNote" + this.noteDirection + ".png");
        } else if (row2.equals("Normal")){
                this.noteDirection = row1;
                this.initialFrame = Integer.parseInt(initialFrame);
                this.lastFrame = this.initialFrame + (int) Math.ceil(668.0/ speed.getYSpeed());
                this.img = new Image("res/note" + this.noteDirection + ".png");
        } else if(row2.equals("Bomb")){
                this.specialType = row2;
                this.noteDirection = row1;
                this.initialFrame = Integer.parseInt(initialFrame);
                this.lastFrame = this.initialFrame + (int) Math.ceil(668.0/ speed.getYSpeed());
                this.img = new Image("res/note" + this.specialType + ".png");
        }

    }
    //methods

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
    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    }

    public void draw(){
        if (visibility){
            img.draw(xCoordinate, yCoordinate);
        }
    }

    public void update(){
        if (visibility){
            yCoordinate += speed.getYSpeed();
        }
    }
}


