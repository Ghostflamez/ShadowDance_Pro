import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import bagel.*;

public class CurrentNote extends NoteSet {

    // Attributes
    private NoteSet originalNotes;
    private List<Note> notes;
    private Speed currentSpeed = new Speed(0, 2);
    public boolean ifDoubleScore = false;
    public boolean isvisible = true;
    private int currentFrame = 0;

    // Constructors

    public CurrentNote(NoteSet noteSet) {
        this.originalNotes = noteSet;
    }
     // Methods
    @Override
    public void update(String command) {
    }

    @Override
    public void update(Input input, int frame) {
        this.currentFrame = frame;
        this.notes = originalNotes.select(this.currentFrame);
        for (Note note : notes) {
            note.updateCoordinate(frame);
        }
    }


    public void speedUp() {
        // Set currentSpeed value
        this.currentSpeed = new Speed(this.currentSpeed.getXSpeed(), this.currentSpeed.getYSpeed() * 2);
    }

    public void speedDown() {
        // Set currentSpeed value
        this.currentSpeed = new Speed(this.currentSpeed.getXSpeed(), this.currentSpeed.getYSpeed() / 2);
    }

    public void deleteNote(Note note) {
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note thisNote = iterator.next();
            if (thisNote.equals(note)) {
                iterator.remove(); // delete the note from the list
            }
        }
    }


    // Assuming other necessary methods if required.
    public void wipe(){
        this.isvisible = false;
    }

    public NoteSet getOriginalNotes() {
        return originalNotes;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }
}

