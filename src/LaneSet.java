import java.util.ArrayList;
import java.util.List;
import ActionModules.Reader;
public class LaneSet {

    // Attributes
    private List<Lane> laneSet;
    private List<List<String>> list;
    private int level;

    // Constructors
    public LaneSet(int level) {
        this.level = level;
        this.laneSet = new ArrayList<>();
        Reader reader = new Reader(); // Instantiate Reader

        this.list = reader.getLaneList(this.level); // Fetch the appropriate laneList
        for (List<String> lane : list) {
            Lane newLane = new Lane(lane.get(1), lane.get(2)); // Extracting the 2nd and 3rd values
            this.addLane(newLane); // Adding the new Lane object to laneSet
        }
    }

    public LaneSet(){
        this.laneSet = new ArrayList<>();
    }


    // Methods
    public void addLane(Lane lane) {
        laneSet.add(lane);
    }

    public int getLevel() {
        return level;
    }

    // Additional methods and attributes can be added as required

}