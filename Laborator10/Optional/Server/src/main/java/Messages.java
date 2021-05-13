public class Messages {
    int id_user;
    String message;

    public Messages(int id_user, String message) {
        this.id_user = id_user;
        this.message = message;
    }

    public Messages() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Messages for" +
                " user " + id_user +
                ": " + message;
    }
}
