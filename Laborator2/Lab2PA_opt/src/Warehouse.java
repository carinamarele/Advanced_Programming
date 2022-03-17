public class Warehouse extends Source {
    /**
     * <p>Constructor pentru obiecte de tipul Warehouse</p>
     *
     * @param name         numele sursei
     * @param capacity     capacitatea sursei
     */
    public Warehouse(String name, int capacity) {
        super(name, capacity);
    }

    /**
     * <p>Creez un string pentru a afisa date despre obiecte de tipul Warehouse</p>
     * @return Stringul cu datele necesare,nume si capacitate
     */
    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name  +
                ", capacity=" + capacity +
                '}';
    }
}
