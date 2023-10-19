package ActionModules;
import java.io.*;
import java.util.*;


public class Reader {
    private static final String FILEPATH1 = "res/level1.csv";
    private static final String FILEPATH2 = "res/level2.csv";
    private static final String FILEPATH3 = "res/level3.csv";
    private List<List<String>> laneList1 = new ArrayList<>();
    private List<List<String>> laneList2 = new ArrayList<>();
    private List<List<String>> laneList3 = new ArrayList<>();
    private List<List<String>> noteList1 = new ArrayList<>();
    private List<List<String>> noteList2 = new ArrayList<>();
    private List<List<String>> noteList3 = new ArrayList<>();

    // Methods
    public  Reader() {
        read(1);
        read(2);
        read(3);
    }

    public void read(int level) {
        String filePath;
        switch (level) {
            case 1:
                filePath = FILEPATH1;
                break;
            case 2:
                filePath = FILEPATH2;
                break;
            case 3:
                filePath = FILEPATH3;
                break;
            default:
                throw new IllegalArgumentException("Invalid level provided");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    if ("Lane".equals(values[0])) {
                        addToLaneList(level, Arrays.asList(values));
                    } else {
                        addToNoteList(level, Arrays.asList(values));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToLaneList(int level, List<String> data) {
        switch (level) {
            case 1:
                laneList1.add(data);
                break;
            case 2:
                laneList2.add(data);
                break;
            case 3:
                laneList3.add(data);
                break;
        }
    }

    private void addToNoteList(int level, List<String> data) {
        switch (level) {
            case 1:
                noteList1.add(data);
                break;
            case 2:
                noteList2.add(data);
                break;
            case 3:
                noteList3.add(data);
                break;
        }
    }



    // Assuming necessary getters, setters, and other utility methods if required.
    public List<List<String>> getLaneList(int level) {
        switch (level) {
            case 1:
                return laneList1;
            case 2:
                return laneList2;
            case 3:
                return laneList3;
            default:
                throw new IllegalArgumentException("Invalid level provided");
        }
    }

    public List<List<String>> getNoteList(int level) {
        switch (level) {
            case 1:
                return noteList1;
            case 2:
                return noteList2;
            case 3:
                return noteList3;
            default:
                throw new IllegalArgumentException("Invalid level provided");
        }
    }
}
