public interface MessagesDAO {
    void insert(int id_user,String name);
    String read(int id_user);
    void send(int id_user,String message);
}
