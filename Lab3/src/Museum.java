import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Visitable, Payable {
    protected LocalTime openingTime,closingTime;
    protected double ticketPrice;

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setCost(Map<String, Integer> cost) {
        super.setCost(cost);
    }

    @Override
    public Map<String, Integer> getCost() {
        return super.getCost();
    }


    @Override
    public void setName(String name) {
        super.setName(name);
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

    @Override
    public String toString() {
        return "Museum{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                ",name="+ name +
                '}';
    }

    @Override
    public void setCost(String node, int value) {
        super.setCost(node, value);
    }
    public void setTicketPrice(double ticketPrice){
        this.ticketPrice=ticketPrice;
    }
    @Override
    public double getTicketPrice(){
        return ticketPrice;
    }
}
