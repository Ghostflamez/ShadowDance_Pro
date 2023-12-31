import ActionModules.Reader;
import bagel.Input;

import java.util.ArrayList;
import java.util.List;

public class NoteSet {
    private List<Note> notes;


    // Constructors
    public NoteSet(int level) {
        this.notes = new ArrayList<>();
        Reader reader = new Reader(); // Instantiate Reader

        // Fetch the appropriate noteList for the given level
        List<List<String>> noteList = reader.getNoteList(level);

        // For each row in noteList, create a Note object using NoteFactory
        // and add it to the notes list.
        for (List<String> noteRow : noteList) {
            Note newNote = NoteFactory.createNote(noteRow.get(0), noteRow.get(1), noteRow.get(2));
            this.addNote(newNote);
        }

        double specialX = 500.0;
        double upX = 500.0;
        double downX = 500.0;
        double leftX = 500.0;
        double rightX = 500.0;

        if (level == 1) {
            upX = 432.0;
            downX = 592.0;
            leftX = 282.0;
            rightX = 742.0;
        } else if (level == 2) {
            specialX = 200.0;
            downX = 592.0;
            leftX = 432.0;
            rightX = 742.0;
        } else if (level == 3) {
            specialX = 150.0;
            leftX = 432.0;
            rightX = 592.0;
        }

        for (Note note : this.notes) {
            if ("Special".equals(note.getType())) {
                note.setXCoordinate(specialX);
            } else {
                if ("Up".equals(note.getDirection())) {
                    note.setXCoordinate(upX);
                } else if ("Down".equals(note.getDirection())) {
                    note.setXCoordinate(downX);
                } else if ("Left".equals(note.getDirection())) {
                    note.setXCoordinate(leftX);
                } else if ("Right".equals(note.getDirection())) {
                    note.setXCoordinate(rightX);
                }
            }
        }
    }

    public NoteSet(List<Note> notes){
        this.notes = notes;
    }
    public NoteSet(){
        this.notes = new ArrayList<>();
    }

    // Methods
    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<Note> getNotes(String type) {
        List<Note> notesByDirection = new ArrayList<>();
        for (Note note : this.notes) {
            if (note.getDirection().equals(type)) {
                notesByDirection.add(note);
            }
        }
        return notesByDirection;
    }

    public void draw(int level) {


    }

    public void draw() {
        for (Note note : this.notes) {
            note.draw();
        }
    }

    public void update(String command) {
        for (Note note : notes) {
            note.update(command);
        }
    }


    public void update(Input input, int frame) {
        for (Note note : this.notes) {
            note.updateCoordinate(frame);
        }
    }

    public void wipe(){
        this.notes = new ArrayList<>();
    }

    public void delete(Note note){
        this.notes.remove(note);
    }



}
