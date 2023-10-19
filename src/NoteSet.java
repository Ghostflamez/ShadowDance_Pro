import ActionModules.Reader;
import java.util.ArrayList;
import java.util.List;

public class NoteSet {
    private List<Note> notes;

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
    }
    public NoteSet(){
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return notes;
    }
}
