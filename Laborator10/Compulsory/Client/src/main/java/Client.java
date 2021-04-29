/**
 * <p>Clasa pentru client pentru a sti numele cat si daca este logat sau nu</p>
 */
public class Client {
    private String name;
    private int logat;

    public Client(String name, int logat) {
        this.name = name;
        this.logat = logat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLogat() {
        return logat;
    }

    public void setLogat(int logat) {
        this.logat = logat;
    }
}
