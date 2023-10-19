import bagel.*;
import ActionModules.*;

import java.util.Iterator;

/**
 * Skeleton Code for SWEN20003 Project 2, Semester 2, 2023
 * Please enter your name below
 * @hongjianz1
 */
public class ShadowDance extends AbstractGame  {
    private final static int WINDOW_WIDTH = 1024;
    private final static int WINDOW_HEIGHT = 768;
    private static final double refY = 657.0;
    private final static String GAME_TITLE = "SHADOW DANCE";
    private final Image BACKGROUND_IMAGE = new Image("res/background.png");

    // Set of objects
    private LaneSet laneSet1;
    private LaneSet laneSet2;
    private LaneSet laneSet3;
    private NoteSet noteSet1;
    private NoteSet noteSet2;
    private NoteSet noteSet3;

    // key input states
    public enum KeyState {
        PRESS,  // Key was pressed this frame
        HOLD,   // Key was pressed in previous frames
        RELEASE,  // Key was released this frame
        FREE    // Key was released in previous frames
    }

    // Key states for each key
    private Player.KeyState upKeyState = Player.KeyState.FREE;
    private Player.KeyState downKeyState = Player.KeyState.FREE;
    private Player.KeyState leftKeyState = Player.KeyState.FREE;
    private Player.KeyState rightKeyState = Player.KeyState.FREE;
    private Player.KeyState spaceKeyState = Player.KeyState.FREE;

    private boolean onePressed = false;
    private boolean twoPressed = false;
    private boolean threePressed = false;
    private boolean tabPressed = false;
    private boolean escPressed = false;

    // flags
    private boolean isPaused = false;
    private String gameState = "Start";

    public ShadowDance(){
        super(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_TITLE);
        this.readCSV();
    }

    /**
     * Method used to read file and create objects (you can change
     * this method as you wish).
     */
    private void readCSV() {
        this.laneSet1 = new LaneSet(1);
        this.laneSet2 = new LaneSet(2);
        this.laneSet3 = new LaneSet(3);
        this.noteSet1 = new NoteSet(1);
        this.noteSet2 = new NoteSet(2);
        this.noteSet3 = new NoteSet(3);
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        ShadowDance game = new ShadowDance();
        game.run();
    }

    /**
     * Performs a state update.
     * Allows the game to exit when the escape key is pressed.
     */
    @Override
    protected void update(Input input) {
        // end game when ESC is pressed
        if (input.wasPressed(Keys.ESCAPE)){
            Window.close();
        }
        // pause game when TAB is pressed
        if (input.wasPressed(Keys.TAB)) {
            this.isPaused = !this.isPaused;
        }

        BACKGROUND_IMAGE.draw(Window.getWidth()/2.0, Window.getHeight()/2.0);

        switch (this.gameState) {
            case "Start":
                this.drawStartingInterface(input);
                break;
            case "Level 1":
                this.drawGameInterface(1,input);
                break;
            case "Level 2":
                this.drawGameInterface(2,input);
                break;
            case "Level 3":
                this.drawGameInterface(3,input);
                break;
            case "Lose":
                this.drawWiningInterface();
                break;
            case "Win":
                this.drawLosingInterface();
                break;
        }
    }

    // draw methods for different windows
    private void drawStartingInterface(Input input) {
        Message TITLE = new Message(80, GAME_TITLE, 150.0, 280.0);
        Message SUBTITLE = new Message(30, "SELECT LEVELS WITH \nNUMBER KEYS", 300.0, 425.0);
        Message CHOICE = new Message(35, "   1      2      3", 300.0, 515.0);
        TITLE.draw();
        SUBTITLE.draw();
        CHOICE.draw();
        if (input.wasPressed(Keys.NUM_1 )) {
            this.gameState = "Level 1";
        } else if (input.wasPressed(Keys.NUM_2)) {
            this.gameState = "Level 2";
        } else if (input.wasPressed(Keys.NUM_3)) {
            this.gameState = "Level 3";
        }
    }
    private void drawGameInterface(int level, Input input) {
        Message test = new Message(80, Integer.toString(level), 150.0, 280.0);
        test.draw();
    }

    private void drawWiningInterface() {

    }
    private void drawLosingInterface() {

    }

}
