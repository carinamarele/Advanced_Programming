import java.time.LocalTime;

public class Restaurant extends Location implements Visitable,Payable,Classifiable{
    protected LocalTime openingTime,closingTime;
    protected double ticketPrice;
    protected int rank;

    @Override
    public String toString() {
        return "Restaurant{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    @Override
    public int getRank() {
        return rank;
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

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public LocalTime getClosingTime(){
        return closingTime;
    }
    public void setTicketPrice(double ticketPrice){
        this.ticketPrice=ticketPrice;
    }
    @Override
    public double getTicketPrice(){
        return ticketPrice;
    }
}
