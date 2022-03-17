import java.util.List;

public interface MovieDAO {
    void create(int id_movie,String title, int release_date,int duration,double score);
    void findByName(String name);
}
