import java.util.Objects;

public abstract class Source {
    public String name;
    public int capacity;

    public Source(String name, int capacity) {
        this.name=name;
        this.capacity=capacity;
    }

    /**
     *<p> Se creeaza un string in care mi se va spune daca sursa este de tip FACTORY sau WAREHOUSE</p>
     *
     * @return un string cu informatii despre numele si capacitatea unui surse
     */
    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    /**
     * <p>Setter pentru preluarea capacitatii</p>
     *
     * @param capacity capacitatea pe care o vom pune capacitatii obiectului de tip Source
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * <p>Setter pentru preluarea numelui sursei</p>
     *
     * @param name numele obiectului de tip Source
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter pentru capacitate</p>
     *
     * @return capacitatea obiectului de tip Source
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * <p>Getter pentru nume</p>
     *
     * @return numele sursei
     */
    public String getName() {
        return name;
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
        Source source = (Source) o;
        return capacity == source.capacity && Objects.equals(name, source.name);
    }

    /**
     * <p>Metoda hash</p>
     *
     * @return valoarea functiei hash aplicata pe obiectul o
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }
}
