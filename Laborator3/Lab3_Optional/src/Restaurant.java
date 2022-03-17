import java.time.LocalTime;
import java.util.Map;

public class Restaurant extends Location implements Visitable,Payable,Classifiable{
    protected LocalTime openingTime,closingTime;
    protected double ticketPrice;
    protected String adresa;
    protected int rank;

    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    /**
     * <p>constructorul care imi initializeaza totul pentru un obiect de tipul restaurant</p>
     * @param openingTime ora de deschidere a restaurantului
     * @param closingTime ora de inchidere a restaurantului
     * @param ticketPrice pretul unui meniu normal,cel al zilei
     * @param adresa adresa la care se gaseste restaurantul
     * @param rank rankul restaurantului,numarul de stele
     */
    public Restaurant(LocalTime openingTime, LocalTime closingTime, double ticketPrice, String adresa,int rank) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
        this.adresa = adresa;
        this.rank=rank;
    }

    public Restaurant() {
    }
//fixarea orei de deschidere si inchidere a restaurantului
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
//settere si gettere pentru preluarea si fixarea pretului pentru un meniu normal plus adresa la care se afla restaurantul
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
//Settere si gettere pentru preluarea si fixarea costului,numelui restaurantului
    @Override
    public void setCost(Location node, int value) {
        super.setCost(node, value);
    }

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
     * <p>Creez un string pentru a afisa toate informatiile obiectului de tip Restaurant</p>
     * @return stringul descris mai sus
     */
    @Override
    public String toString() {
        return COLOR_GREEN+"Restaurantul " +
                 RESET+name  +
                " se deschide la ora " + openingTime +
                ", se inchide la ora " + closingTime +
                ", pretul meniului zilei este de" + ticketPrice +
                "RON si se afla pe Strada " + adresa +'.'+"\n";
    }

    @Override
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

}
