public class Client {
    private String name;
    private int logat;

    public Client() {
        this.logat = 0;
    }

    public Client(String name) {
        this.name = name;
        this.logat = 0;
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
