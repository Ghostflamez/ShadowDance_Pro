import java.util.List;

public class NoteFactory {
    public static Note createNote(String row1, String row2, String initialFrame) {
        if ("Special".equals(row1)) {
            return new SpecialNote(row1,row2, initialFrame);
        } else if ("Hold".equals(row2)) {
            return new HoldNote(row1, row2, initialFrame);
        } else if ("Normal".equals(row2)) {
            return new Note(row1, row2, initialFrame); // Assuming normal note uses the base Note class
        } else if ("Bomb".equals(row2)) {
            return new BombNote(row1, row2, initialFrame);
        } else {
            throw new IllegalArgumentException("Invalid note type");
        }
    }
}
