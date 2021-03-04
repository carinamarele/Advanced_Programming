import java.util.HashMap;
import java.util.Map;

public abstract class Location implements  Comparable<Location> {
    protected String name;
    protected Map<String, Integer> cost =new HashMap<String, Integer>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<String, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(String node, int value){
        cost.put(node,value);
    }
    public int compareTo(Location other){
        return this.name.compareTo(other.name);
    }


}
