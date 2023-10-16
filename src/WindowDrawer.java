public class WindowDrawer {


    //methods
    private void drawInitialInterface() {
        this.TITLE_FONT.drawString("SHADOW DANCE", 220.0, 250.0, this.TITLE_OPTIONS);
        this.INSTRUCTION_FONT.drawString("PRESS SPACE TO START", 320.0, 440.0, this.INSTRUCTION_OPTIONS);
        this.INSTRUCTION_FONT.drawString("USE ARROW KEYS TO PLAY", 320.0, 490.0, this.INSTRUCTION_OPTIONS);
    }

    private void drawPlayingInterface() {
        this.drawScore();
        this.drawCombo();
        this.drawSpeed();
        this.drawNotes();
        this.drawMovingObjects();
        this.drawPlayer();
    }
}
