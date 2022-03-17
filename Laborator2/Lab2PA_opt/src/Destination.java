import java.util.Objects;

public class Destination {
    public String name;
    public int demand;

    /**
     * <p>Constructor care imi initializeaza datele pentru un obiect de tipul Destination</p>
     *
     * @param name   numele destinatiei
     * @param demand demand ul destinatiei
     */
    public Destination(String name,int demand) {
        this.name=name;
        this.demand = demand;
    }

    /**
     * <p>Creez un string pentru a afisa date despre Destinatii,numele si demand ul destinatiei</p>
     * @return string cu datele mentionate mai sus
     */
    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", demand=" + demand +
                '}';
    }

    /**
     * <p>Getter pentru demand</p>
     * @return demand ul destinatiei
     */
    public int getDemand() {
        return demand;
    }

    /**
     * <p>Setter pentru a seta demand ul destinatiei</p>
     * @param demand demand ul pe care il vom pune noi obiectului de tip Destination
     */
    public void setDemand(int demand) {
        this.demand = demand;
    }
    /**
     * <p>Metoda equals verifca daca un obiect nu este declarat de doua ori</p>
     * @param o obiect de tip sursa care este verificat daca a mai fost sau nu declarat
     * @return true/false in functie de verificarea acestuia
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(name, that.name);
    }

    /**
     * <p>Metoda hash</p>
     *
     * @return valoarea functiei hash aplicata pe obiectul o
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * <p>Setter pentru setarea numelui</p>
     * @param name numele destinatiei
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter pentru preluarea numelui</p>
     * @return numele destinatiei
     */
    public String getName() {
        return name;
    }
}
