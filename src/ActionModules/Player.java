package ActionModules;
import bagel.*;

public class Player {

    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean spacePressed = false;

    private boolean upReleased = false;
    private boolean downReleased = false;
    private boolean leftReleased = false;
    private boolean rightReleased = false;
    private boolean spaceReleased = false;

    // Constructor
    public Player() {

    }

    // Methods
    public void update(Input input) {
        if (input.wasPressed(Keys.LEFT)) {
            leftPressed = true;
        }
        if (input.wasPressed(Keys.RIGHT)) {
            rightPressed = true;
        }
        if (input.wasPressed(Keys.UP)) {
            //
            upPressed = true;
        }
        if (input.wasPressed(Keys.DOWN)) {
            downPressed = true;
        }
        if (input.wasPressed(Keys.SPACE)) {
            spacePressed = true;
        }

        //detect keyboard release
        if (input.wasReleased(Keys.LEFT)) {
            leftReleased = true;
        }
        if (input.wasReleased(Keys.RIGHT)) {
            rightReleased = true;
        }
        if (input.wasReleased(Keys.UP)) {
            upReleased = true;
        }
        if (input.wasReleased(Keys.DOWN)) {
            downReleased = true;
        }
        if (input.wasReleased(Keys.SPACE)) {
            spaceReleased = true;
        }

    }

    // Setters
    public void resetUpPressed() {
        this.upPressed = false;
    }

    public void resetDownPressed() {
        this.downPressed = false;
    }

    public void resetLeftPressed() {
        this.leftPressed = false;
    }

    public void resetRightPressed() {
        this.rightPressed = false;
    }

    public void resetSpacePressed() {
        this.spacePressed = false;
    }

    public void resetUpReleased() {
        this.upReleased = false;
    }

    public void resetDownReleased() {
        this.downReleased = false;
    }

    public void resetLeftReleased() {
        this.leftReleased = false;
    }

    public void resetRightReleased() {
        this.rightReleased = false;
    }

    public void resetSpaceReleased() {
        this.spaceReleased = false;
    }

    // Getters
    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isSpacePressed() {
        return spacePressed;
    }

    public boolean isUpReleased() {
        return upReleased;
    }

    public boolean isDownReleased() {
        return downReleased;
    }

    public boolean isLeftReleased() {
        return leftReleased;
    }

    public boolean isRightReleased() {
        return rightReleased;
    }

    public boolean isSpaceReleased() {
        return spaceReleased;
    }



}
