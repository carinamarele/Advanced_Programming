
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreController implements GenresDAO {
    Database database;

    public GenreController(Database database) {
        this.database = database;
    }

    @Override
    public void create(int id_genre, String name) {
        try {
            PreparedStatement statement = database.connection.prepareStatement("insert into genres (id_genre,name) values (?,?)");
            statement.setInt(1, id_genre);
            statement.setString(2, name);
            statement.execute();
            System.out.println("New row inserted in genre table");
            statement.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

//metoda pentru a afisa filmele cu un gen dat
    @Override
    public void findByName(String name) throws NullPointerException {
        List<Movie> movies = new ArrayList<>();
        Movie newMovie;
        try {
            PreparedStatement statement = database.connection.prepareStatement("select movies.id_movie,movies.title,movies.release_date,movies.duration,movies.score from movies join film on movies.id_movie=film.id_movie join genres on film.id_genre=genres.id_genre and genres.name=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                    newMovie = new Movie(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getDouble(5));
                    movies.add(newMovie);

                }
                resultSet.close();
                statement.close();
            if (movies.size() == 0) System.out.println("Nu s-a gasit nimic!");
            else
                for (int i = 0; i < movies.size(); i++)
                    System.out.println(movies.get(i));
        } catch (SQLException exp) {
            exp.printStackTrace();
        }

    }

}
