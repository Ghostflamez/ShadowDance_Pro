import bagel.*;
import ActionModules.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Skeleton Code for SWEN20003 Project 2, Semester 2, 2023
 * Please enter your name below
 * @hongjianz1
 */
public class ShadowDance extends AbstractGame {
    private final static int WINDOW_WIDTH = 1024;
    private final static int WINDOW_HEIGHT = 768;
    private static final double refY = 657.0;
    private final static String GAME_TITLE = "SHADOW DANCE";
    private final Image BACKGROUND_IMAGE = new Image("res/background.png");

    // Set of objects
    private LaneSet laneSet1;
    private LaneSet laneSet2;
    private LaneSet laneSet3;
    private LaneSet thisLaneSet;
    private NoteSet noteSet1;
    private NoteSet noteSet2;
    private NoteSet noteSet3;

    private CurrentNote currentNote1;
    private CurrentNote currentNote2;
    private CurrentNote currentNote3;
    private CurrentNote thisCurrentNote;

    // initialize key input states
    Player player = new Player();

    // flags
    private boolean isPaused = false;
    private String gameState = "Start";
    private String banner;
    private boolean isDoubleScore = false;
    private int doubleScoreBonus = 1;
    private boolean wipe = false;

    // timers
    private int bannerFrame = 0;
    private int doublescoreFrame = 0;

    // sort lists of notes
    private List<SpecialNote> specialNotes = new ArrayList<>();

    private List<HoldNote> holdNotesUp = new ArrayList<>();
    private List<HoldNote> holdNotesDown = new ArrayList<>();
    private List<HoldNote> holdNotesLeft = new ArrayList<>();
    private List<HoldNote> holdNotesRight = new ArrayList<>();

    private List<BombNote> bombNotesUp = new ArrayList<>();
    private List<BombNote> bombNotesDown = new ArrayList<>();
    private List<BombNote> bombNotesLeft = new ArrayList<>();
    private List<BombNote> bombNotesRight = new ArrayList<>();
    private List<BombNote> bombNotesSpecial = new ArrayList<>();

    private List<Note> normalNotesUp = new ArrayList<>();
    private List<Note> normalNotesDown = new ArrayList<>();
    private List<Note> normalNotesLeft = new ArrayList<>();
    private List<Note> normalNotesRight = new ArrayList<>();

    // counters
    private int currentFrame = 0;  // frame counter
    private int score = 0;  // score counter


    public ShadowDance() {
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

        this.currentNote1 = new CurrentNote(this.noteSet1);
        this.currentNote2 = new CurrentNote(this.noteSet2);
        this.currentNote3 = new CurrentNote(this.noteSet3);
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
        if (input.wasPressed(Keys.ESCAPE)) {
            Window.close();
        }

        BACKGROUND_IMAGE.draw(Window.getWidth() / 2.0, Window.getHeight() / 2.0);

        switch (this.gameState) {
            case "Start":
                this.drawStartingInterface(input);
                break;
            case "Level 1":
                this.drawGameInterface(1, input);
                break;
            case "Level 2":
                this.drawGameInterface(2, input);
                break;
            case "Level 3":
                this.drawGameInterface(3, input);
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
        if (input.wasPressed(Keys.NUM_1)) {
            this.gameState = "Level 1";
        } else if (input.wasPressed(Keys.NUM_2)) {
            this.gameState = "Level 2";
        } else if (input.wasPressed(Keys.NUM_3)) {
            this.gameState = "Level 3";
        }
    }


    private void drawGameInterface(int level, Input input) {
        // pause game when TAB is pressed
        if (input.wasPressed(Keys.TAB)) {
            this.isPaused = !this.isPaused;
        }

        if (!this.isPaused){
            ++this.currentFrame;
        }
        // update frame counter
        player.update(input);

        // draw static elements
        Message test = new Message(20, "Level " + Integer.toString(level), 17.0, 748.0);
        Message frame = new Message(10, "Frame " + Integer.toString(this.currentFrame), 940.0, 18.0);
        Message score = new Message(30, "Score " + this.score, 35.0, 35.0);
        test.draw();
        frame.draw();
        score.draw();

        // draw dynamic elements
        List<Note> notes = new ArrayList<>();
        NoteSet q = new NoteSet();
        List<Note> current = new ArrayList<>();

        // draw notes
        switch (level) {
            case 1:
                this.thisCurrentNote = this.currentNote1;
                this.thisLaneSet = this.laneSet1;
                break;
            case 2:
                this.thisCurrentNote = this.currentNote2;
                this.thisLaneSet = this.laneSet2;
                break;
            case 3:
                this.thisCurrentNote = this.currentNote3;
                this.thisLaneSet = this.laneSet3;
        }

        this.thisLaneSet.draw();
        // select notes to be drawn
        this.thisCurrentNote.select(this.currentFrame);
        this.thisCurrentNote.update("keepSpeed", this.currentFrame);

        // draw notes
        this.thisCurrentNote.draw();

        // note sorting
        for (Note note : this.thisCurrentNote.getNotes()) {
            if ("Hold".equals(note.getType())) {
                if ("Up".equals(note.getDirection())){
                    this.holdNotesUp.add((HoldNote) note);
                } else if ("Down".equals(note.getDirection())) {
                    this.holdNotesDown.add((HoldNote) note);
                } else if ("Left".equals(note.getDirection())) {
                    this.holdNotesLeft.add((HoldNote) note);
                } else if ("Right".equals(note.getDirection())) {
                    this.holdNotesRight.add((HoldNote) note);
                }

            } else if ("Bomb".equals(note.getType())) {
                if ("Up".equals(note.getDirection())){
                    this.bombNotesUp.add((BombNote) note);
                } else if ("Down".equals(note.getDirection())) {
                    this.bombNotesDown.add((BombNote) note);
                } else if ("Left".equals(note.getDirection())) {
                    this.bombNotesLeft.add((BombNote) note);
                } else if ("Right".equals(note.getDirection())) {
                    this.bombNotesRight.add((BombNote) note);
                } else if ("Special".equals(note.getDirection())){
                    this.bombNotesSpecial.add((BombNote) note);
                }

            } else if ("Normal".equals(note.getType())){
                if ("Up".equals(note.getDirection())){
                    this.normalNotesUp.add(note);
                } else if ("Down".equals(note.getDirection())) {
                    this.normalNotesDown.add(note);
                } else if ("Left".equals(note.getDirection())) {
                    this.normalNotesLeft.add(note);
                } else if ("Right".equals(note.getDirection())) {
                    this.normalNotesRight.add(note);
                }

            } else if ("Special".equals(note.getType())){
                this.specialNotes.add((SpecialNote) note);
            }
        }

        // score calculation
        // The following code is used to calculate the score after press action
        //bonus score
        if (player.isSpaceReleased() && !player.isSpacePressed()) {
            for (Note note : this.specialNotes) {
                switch (note.getSpecialType()) {
                    case "DoubleScore":
                        this.isDoubleScore = true;
                        this.doubleScoreBonus = 2;
                        this.doublescoreFrame = 0;
                        break;
                    case "SpeedUp":
                        this.thisCurrentNote.speedUp();
                        break;
                    case "SpeedDown":
                        this.thisCurrentNote.speedDown();
                        break;
                }
            }

            // reset doubleScore states
            if (this.isDoubleScore) {
                ++this.doublescoreFrame;
                if (this.doublescoreFrame > 480) {
                    this.isDoubleScore = false;
                    this.doubleScoreBonus = 1;
                    this.doublescoreFrame = 0;
                }
            }
        }

        // Up
        if (player.isUpReleased() && !player.isUpPressed()) {
            int normalUpScore = 0;
            for (Note note : this.normalNotesUp) {
                normalUpScore = note.getScore();
                this.setBanner(note.getMark());
            }

            int holdUpScore = 0;
            for (Note note : this.holdNotesUp) {
                holdUpScore = note.getScore();
                this.setBanner(note.getMark());
            }

            for (BombNote note : this.bombNotesUp) {
                if (note.isTriggered()) this.wipe = true;
            }

            int totalUpScore = normalUpScore + holdUpScore;
            this.score += totalUpScore * this.doubleScoreBonus;
            player.resetUpPressed();
        }
        if (player.isUpReleased()) {
            player.resetUpReleased();
        }

        // Down
        if (player.isDownPressed() && !player.isDownReleased()) {
            int normalDownScore = 0;
            for (Note note : this.normalNotesDown) {
                normalDownScore = note.getScore();
                this.setBanner(note.getMark());
            }

            int holdDownScore = 0;
            for (Note note : this.holdNotesDown) {
                holdDownScore = note.getScore();
                this.setBanner(note.getMark());
            }

            for (BombNote note : this.bombNotesDown) {
                if (note.isTriggered()) this.wipe = true;
            }

            int totalDownScore = normalDownScore + holdDownScore;
            this.score += totalDownScore * this.doubleScoreBonus;
            player.resetDownPressed();
        }
        if (player.isDownReleased()) {
            player.resetDownReleased();
        }

        // Left
        if (player.isLeftPressed() && !player.isLeftReleased()) {
            int normalLeftScore = 0;
            for (Note note : this.normalNotesLeft) {
                normalLeftScore = note.getScore();
                this.setBanner(note.getMark());
            }

            int holdLeftScore = 0;
            for (Note note : this.holdNotesLeft) {
                holdLeftScore = note.getScore();
                this.setBanner(note.getMark());
            }

            for (BombNote note : this.bombNotesLeft) {
                if (note.isTriggered()) this.wipe = true;
                this.setBanner(note.getMark());
            }

            int totalLeftScore = normalLeftScore + holdLeftScore;
            this.score += totalLeftScore * this.doubleScoreBonus;
            player.resetLeftPressed();
        }
        if (player.isLeftReleased()) {
            player.resetLeftReleased();
        }

        // Right
        if (player.isRightPressed() && !player.isRightReleased()) {
            int normalRightScore = 0;
            for (Note note : this.normalNotesRight) {
                normalRightScore = note.getScore();
                this.setBanner(note.getMark());
            }

            int holdRightScore = 0;
            for (Note note : this.holdNotesRight) {
                holdRightScore = note.getScore();
                this.setBanner(note.getMark());
            }

            for (BombNote note : this.bombNotesRight) {
                if (note.isTriggered()) this.wipe = true;
            }

            int totalRightScore = normalRightScore + holdRightScore;
            this.score += totalRightScore * this.doubleScoreBonus;
            player.resetRightPressed();
        }
        if (player.isRightReleased()) {
            player.resetRightReleased();
        }

        // Space
        if (player.isSpacePressed() && !player.isSpaceReleased()) {
            for (BombNote note : this.bombNotesSpecial) {
                if (note.isTriggered()) this.wipe = true;
            }
            player.resetSpacePressed();
        }

        // The following code is used to calculate the score after release action
        // up
        if (player.isUpReleased()) {
            int holdUpScore = 0;
            for (Note note : this.holdNotesUp) {
                holdUpScore += note.getScore();
                this.setBanner(note.getMark());
            }
            this.score += holdUpScore * this.doubleScoreBonus;
            player.resetUpReleased();
        }

        // down
        if (player.isDownReleased()) {
            int holdDownScore = 0;
            for (Note note : this.holdNotesDown) {
                holdDownScore += note.getScore();
                this.setBanner(note.getMark());
            }
            this.score += holdDownScore * this.doubleScoreBonus;
            player.resetDownReleased();
        }

        // left
        if (player.isLeftReleased()) {
            int holdLeftScore = 0;
            for (Note note : this.holdNotesLeft) {
                holdLeftScore += note.getScore();
                this.setBanner(note.getMark());
            }
            this.score += holdLeftScore * this.doubleScoreBonus;
            player.resetLeftReleased();
        }

        // right
        if (player.isRightReleased()) {
            int holdRightScore = 0;
            for (Note note : this.holdNotesRight) {
                holdRightScore += note.getScore();
                this.setBanner(note.getMark());
            }
            this.score += holdRightScore * this.doubleScoreBonus;
            player.resetRightReleased();
        }

        // space
        if (player.isSpaceReleased()) {
            player.resetSpaceReleased();
        }

        // wipe notes
        if (this.wipe) {
            this.thisCurrentNote.wipe();
            this.wipe = false;
            this.banner = "Lane Clear";
        }

        // draw banner
        if (this.bannerFrame > 0) {
            Message banner = new Message(40, this.banner, WINDOW_WIDTH / 2.0, WINDOW_HEIGHT / 2.0);
            banner.draw();
            this.bannerFrame--;  // 递减帧计数

            if (this.bannerFrame == 0) {
                this.banner = "";  // 清除消息
            }
        }




    }



    private void drawWiningInterface() {

    }

    private void drawLosingInterface() {

    }

    public void setBanner(String message) {
        this.banner = message;
        this.bannerFrame = 30;  // reset banner frame
    }


}

