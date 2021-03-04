import java.time.LocalTime;

public class Hotel extends Location implements Visitable, Payable, Classifiable {
    protected LocalTime openingTime, closingTime;
    protected double ticketPrice;
    protected int rank;

    @Override
    public String toString() {

        return "Hotel{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                ", rank=" + rank +
                ",name="+name+
                '}';
    }

    @Override
    public int compareTo(Location other) {
        return super.compareTo(other);
    }

    @Override
    public int getRank() {
        return rank;
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
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }
}
