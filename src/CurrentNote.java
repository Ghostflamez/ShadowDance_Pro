import bagel.Input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurrentNote extends NoteSet {

    // Attributes
    private NoteSet originalNotes;
    private List<Note> notes;
    private Speed currentSpeed;
    public boolean ifDoubleScore = false;
    public boolean isvisible = true;
    private int currentFrame = 0;

    // Constructors

    public CurrentNote(NoteSet noteSet) {
        this.originalNotes = noteSet;
        this.currentSpeed = new Speed(0.0, 2.0);
        this.notes = new ArrayList<>();
    }
     // Methods
    @Override
    public void update(String command) {
    }

    public void update(String speedGear, int frame) {
        this.currentFrame = frame;
        if (speedGear.equals("speedUp")) {
            speedUp();
        } else if (speedGear.equals("speedDown")) {
            speedDown();
        } else if (speedGear.equals("keepSpeed")) {
            // do nothing
        }
        for (Note note : this.notes) {
            note.setSpeed(this.currentSpeed);
            note.updateCoordinate(frame);
        }
    }


    public void speedUp() {
        // Set currentSpeed value
        this.currentSpeed = new Speed(this.currentSpeed.getXSpeed(), this.currentSpeed.getYSpeed() + 1.0);
    }

    public void speedDown() {
        // Set currentSpeed value
        this.currentSpeed = new Speed(this.currentSpeed.getXSpeed(), this.currentSpeed.getYSpeed() - 1.0);
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

    public NoteSet getOriginalNotes() {
        return originalNotes;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    @Override
    public void wipe() {
        for (Note note : this.notes) {
            this.originalNotes.delete(note);
        }
        this.notes = new ArrayList<>();
    }

    public void select(int frame) {
        List<Note> current = new ArrayList<>();

        for (Note note : this.originalNotes.getNotes()) {
            if (note.getInitialFrame() <= frame && frame <= note.getLastFrame()) {
                current.add(note);
            }
        }
        this.notes = current;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void draw() {
        for (Note note : this.notes) {
            note.draw();
        }
    }
}

