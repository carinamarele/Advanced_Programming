public class User_Network {
    int id_user;
    String name;
    int logged;

    public User_Network(int id_user, String name, int logged) {
        this.id_user = id_user;
        this.name = name;
        this.logged = logged;
    }

    public User_Network() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLogged() {
        return logged;
    }

    public void setLogged(int logged) {
        this.logged = logged;
    }

    @Override
    public String toString() {
        return "Userul cu ID-ul" + id_user +
                "is named " + name  ;
    }
}
