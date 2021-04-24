

public interface GenresDAO {
    void create(int id_genre, String name);
    void findByName(String name);
}
