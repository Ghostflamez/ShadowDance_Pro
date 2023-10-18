、package ActionModules;
import bagel.*;

public class Player {
    private Input input;

    // Enum for key states
    public enum KeyState {
        PRESS,  // Key was pressed this frame
        HOLD,   // Key was pressed in previous frames
        RELEASE,  // Key was released this frame
        FREE    // Key was released in previous frames
    }

    // Key states for each key
    private KeyState upKeyState = KeyState.FREE;
    private KeyState downKeyState = KeyState.FREE;
    private KeyState leftKeyState = KeyState.FREE;
    private KeyState rightKeyState = KeyState.FREE;
    private KeyState spaceKeyState = KeyState.FREE;

    private boolean upWasReleased = false;
    private boolean downWasReleased = false;
    private boolean leftWasReleased = false;
    private boolean rightWasReleased = false;
    private boolean spaceWasReleased = false;

    // Constructor
    public Player(Input input) {
        this.input = input;
    }

    // Methods
    public boolean isEscPressed() {
        return input.isDown(Keys.ESCAPE);
    }

    public boolean isUpPressed() {
        return upKeyState == KeyState.PRESS;
    }

    public boolean isUpHeld() {
        return upKeyState == KeyState.PRESS || upKeyState == KeyState.HOLD;
    }

    public boolean isDownPressed() {
        return downKeyState == KeyState.PRESS;
    }

    public boolean isDownHeld() {
        return downKeyState == KeyState.PRESS || downKeyState == KeyState.HOLD;
    }

    public boolean isLeftPressed() {
        return leftKeyState == KeyState.PRESS;
    }

    public boolean isLeftHeld() {
        return leftKeyState == KeyState.PRESS || leftKeyState == KeyState.HOLD;
    }

    public boolean isRightPressed() {
        return rightKeyState == KeyState.PRESS;
    }

    public boolean isRightHeld() {
        return rightKeyState == KeyState.PRESS || rightKeyState == KeyState.HOLD;
    }

    public boolean isSpacePressed() {
        return spaceKeyState == KeyState.PRESS;
    }

    public boolean isSpaceHeld() {
        return spaceKeyState == KeyState.PRESS || spaceKeyState == KeyState.HOLD;
    }

    public void update() {
        if (input.isDown(Keys.UP)) {
            if (upWasReleased) {
                upKeyState = KeyState.PRESS;
                upWasReleased = false;
            } else if (upKeyState == KeyState.PRESS) {
                upKeyState = KeyState.HOLD;
            }
        } else if (upKeyState != KeyState.FREE) {
            upKeyState = KeyState.RELEASE;
            upWasReleased = true;
        }

        if (input.isDown(Keys.DOWN)) {
            if (downWasReleased) {
                downKeyState = KeyState.PRESS;
                downWasReleased = false;
            } else if (downKeyState == KeyState.PRESS) {
                downKeyState = KeyState.HOLD;
            }
        } else if (downKeyState != KeyState.FREE) {
            downKeyState = KeyState.RELEASE;
            downWasReleased = true;
        }

        if (input.isDown(Keys.LEFT)) {
            if (leftWasReleased) {
                leftKeyState = KeyState.PRESS;
                leftWasReleased = false;
            } else if (leftKeyState == KeyState.PRESS) {
                leftKeyState = KeyState.HOLD;
            }
        } else if (leftKeyState != KeyState.FREE) {
            leftKeyState = KeyState.RELEASE;
            leftWasReleased = true;
        }

        if (input.isDown(Keys.RIGHT)) {
            if (rightWasReleased) {
                rightKeyState = KeyState.PRESS;
                rightWasReleased = false;
            } else if (rightKeyState == KeyState.PRESS) {
                rightKeyState = KeyState.HOLD;
            }
        } else if (rightKeyState != KeyState.FREE) {
            rightKeyState = KeyState.RELEASE;
            rightWasReleased = true;
        }

        if (input.isDown(Keys.SPACE)) {
            if (spaceWasReleased) {
                spaceKeyState = KeyState.PRESS;
                spaceWasReleased = false;
            } else if (spaceKeyState == KeyState.PRESS) {
                spaceKeyState = KeyState.HOLD;
            }
        } else if (spaceKeyState != KeyState.FREE) {
            spaceKeyState = KeyState.RELEASE;
            spaceWasReleased = true;
        }
    }
}
