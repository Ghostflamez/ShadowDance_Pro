import java.util.ArrayList;
import java.util.List;
public class NoteSet {
    private List<Note> notes;

    public NoteSet() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}
