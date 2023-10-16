import java.util.List;

public class CurrentNote {

    // Attributes
    private List<Note> currentNoteSet;
    private int mode = 1;
    private Speed CurrentSpeed;
    public boolean ifDoubleScore;

    // Methods
    public void update(Speed CurrentSpeed) {
        // Method implementation
    }

    public int getMode() {
        // Return mode value
        return mode;
    }

    public Speed getSpeed() {
        // Return CurrentSpeed value
        return CurrentSpeed;
    }

    public List<Note> getNoteSet() {
        // Return currentNoteSet value
        return currentNoteSet;
    }

    public void addNote(Note note) {
        // Add note to currentNoteSet
    }

    public void deleteNote(Note note) {
        // Delete note from currentNoteSet
    }

    // Assuming other necessary methods if required.

}

