import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Visitable, Payable {
    protected LocalTime openingTime,closingTime;
    protected double ticketPrice;
    protected String adresa;

    /**
     * <p>Constructor care initializeaza un obiect de tip Museum</p>
     * @param openingTime ora deschiderii
     * @param closingTime ora inchiderii
     * @param ticketPrice pretul intrarii
     * @param adresa adresa la care se gaseste muzeul
     */
    public Museum(LocalTime openingTime, LocalTime closingTime, double ticketPrice, String adresa) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
        this.adresa = adresa;
    }

    public Museum() {
    }
//settere si getttere pentru preluarea si fixarea adresei la care se gaseste muzeul,ora inchiderii,ora deschiderii si pretul de intrare
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
//settere si gettere pentru preluarea si fixarea costului si numelui muzeului
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
     * <p>Creez un string pentru a afisa informatii despre obiectul creat</p>
     * @return stringul creat
     */
    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
