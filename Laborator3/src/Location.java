import java.util.HashMap;
import java.util.Map;

public abstract class Location implements  Comparable<Location> {
    protected String name;
    protected Map<Location, Integer> cost =new HashMap<>();

    /**
     * <p>Setter pentru fixarea unui nume</p>
     * @param name numele Locatiei
     */
    public void setName(String name) {
        this.name = name;
    }
//Setter si Gettere pentru name si pentru cost de timp Map
    public String getName() {
        return name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Location node, int value){
        cost.put(node,value);
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }
}
