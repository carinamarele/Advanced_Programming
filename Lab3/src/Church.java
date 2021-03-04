import java.time.LocalTime;
import java.util.Map;

public class Church extends Location implements  Visitable{
    protected LocalTime openingTime,closingTime;

    @Override
    public void setCost(Map<String, Integer> cost) {
        super.setCost(cost);
    }

    @Override
    public Map<String, Integer> getCost() {
        return super.getCost();
    }

    @Override
    public String toString() {
        return "Church{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", name=" + name+
                '}';
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setCost(String node, int value) {
        super.setCost(node, value);
    }

    @Override
    public int compareTo(Location other) {
        return super.compareTo(other);
    }

    @Override
    public LocalTime getOpeningTime(){
        return openingTime;
    }
    public void setOpeningTime(LocalTime openingTime){
        this.openingTime=openingTime;
    }
    public void setClosingTime(LocalTime closingTime){
        this.closingTime=closingTime;
    }

    public LocalTime getClosingTime(){
        return closingTime;
    }
}
