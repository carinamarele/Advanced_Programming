public class Factories extends Source {
    /**
     * <p>Constructor pentru obiecte de tipul Factories</p>
     *
     * @param name          numele tipului de sursa
     * @param capacity      capacitatea sursei
     */
    public Factories(String name, int capacity) {
        super(name, capacity);
    }

    /**
     * <p>Creez un string care imi spune numele sursei si capacitatea</p>
     * @return Un string cu datele necesare,nume si capacitate
     */
    @Override
    public String toString() {
        return "Factories{" +
                "name='" + name  +
                ", capacity=" + capacity +
                '}';
    }
}
