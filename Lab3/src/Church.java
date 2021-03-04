import java.time.LocalTime;
import java.util.Map;

public class Church extends Location implements  Visitable{
    protected LocalTime openingTime,closingTime;
    protected String adresa,religie;
    protected int capacitate;

    /**
     * <p>Constructorul care initializeaza un obiect de tipul Church</p>
     * @param openingTime ora dechiderii
     * @param closingTime ora inchiderii
     * @param adresa adresa la care se gaseste biserica
     * @param religie religia,tipul bisericii
     * @param capacitate capacitatea maxima de oameni care pot fi in biserica
     */
    public Church(LocalTime openingTime, LocalTime closingTime, String adresa, String religie, int capacitate) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.adresa = adresa;
        this.religie = religie;
        this.capacitate = capacitate;
    }

    public Church() {
    }
//settere si gettere pentru fixarea orei de inchidere/deschidere,adresa la care se gaseste biserica
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
//settere si gettere pentru fixarea tipului de religie si capacitatea maxima de persoane care pot fi in biserica
    public String getReligie() {
        return religie;
    }

    public void setReligie(String religie) {
        this.religie = religie;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }
//settere si gettere pentru preluarea si fixarea costului,numelui bisericii

    @Override
    public void setCost(Map<Location, Integer> cost) {
        super.setCost(cost);
    }

    @Override
    public Map<Location, Integer> getCost() {
        return super.getCost();
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
    public void setCost(Location node, int value) {
        super.setCost(node, value);
    }

    /**
     * <p>Creez un string pentru a afisa informatii despre un obiect de tipul Church</p>
     * @return stringul cu toate informatiile
     */
    @Override
    public String toString() {
        return "Church{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", adresa='" + adresa + '\'' +
                ", religie='" + religie + '\'' +
                ", capacitate=" + capacitate +
                ", name='" + name + '\'' +
                '}';
    }

}
