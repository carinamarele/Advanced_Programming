public class Relation {
    int id_user;
    int id_friend;

    public Relation(int id_user, int id_friend) {
        this.id_user = id_user;
        this.id_friend = id_friend;
    }

    public Relation() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_friend() {
        return id_friend;
    }

    public void setId_friend(int id_friend) {
        this.id_friend = id_friend;
    }

    @Override
    public String toString() {
        return "Friendships between" +
                "User Id" + id_user +
                "and Friend Id" + id_friend ;
    }
}
