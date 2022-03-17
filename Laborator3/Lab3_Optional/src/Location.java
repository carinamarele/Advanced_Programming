import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    /**
     * <p>Functia imi spune daca exista muchie intre doua locatii,daca exista un cost intre doua locatii</p>
     * <p> Daca exista atunci imi va returna costul,altfel va returna -1</p>
     * @param id1 reprezinta locatia care se va cauta in vectorul de locatii a obiectului curent
     * @return costul in cazul in care exista muchie,altfel -1
     */
    public int verifyExistingCost(Location id1){
        for (Location id : this.cost.keySet()) {
            if(id.name.equals(id1.name))
             return id1.cost.get(id);
        }
        return 0 ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && Objects.equals(cost, location.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    public void setCost(Location node, int value){
        cost.put(node,value);
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }
}
