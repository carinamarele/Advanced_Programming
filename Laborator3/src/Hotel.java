import java.time.LocalTime;
import java.util.Map;

public class Hotel extends Location implements Visitable, Payable, Classifiable {
    protected LocalTime openingTime,closingTime;
    protected double ticketPrice;
    protected String adresa;
    protected int rank;

    /**
     * <p>Constructor pentru initializarea unui obiect de tip Hotel</p>
     * @param openingTime ora inceperii,deschiderii hotelului
     * @param closingTime ora de inchidere a hotelului
     * @param ticketPrice pretul pe o noapte pentru o camera single,normala
     * @param adresa adresa unde se gaseste hotelul
     * @param rank un rank(nr de stele)
     */
    public Hotel(LocalTime openingTime, LocalTime closingTime, double ticketPrice, String adresa,int rank) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
        this.adresa = adresa;
        this.rank=rank;
    }

    public Hotel() {
    }
//Settere si gettere pentru fixarea orei de deschidere si inchidere a hotelului
    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
//Settere si gettere pentru preluarea si fixarea pretului unui bilet cat si fixarea adresei hotelului
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public void setCost(Location node, int value) {
        super.setCost(node, value);
    }
//settere si gettere pentru preluarea si fixarea unui name si costului
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Map<Location, Integer> getCost() {
        return super.getCost();
    }

    @Override
    public void setCost(Map<Location, Integer> cost) {
        super.setCost(cost);
    }

    /**
     * <p> Creez un string pentru a afisa informatiile despre obiectul creat</p>
     * @return stringul cu datele necesare
     */
    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                ", adresa='" + adresa + '\'' +
                '}';
    }
//setter si getter pentru preluarea rankului hotelului,in caz de are
    @Override
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
