
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Contine metodele pe care le apelez cand apas un buton</p>
 */
public class MovieController implements MovieDAO{

    Database database;

    public MovieController(Database database) {
        this.database = database;
    }
    //creez conexiunea cu tabelul movie
    @Override
    public void create(int id_movie, String title, int release_date, int duration, double score) {
        try{
            PreparedStatement statement=database.connection.prepareStatement("insert into movies (id_movie,title,release_date,duration,score) values(?,?,to_date(?,'yyyy'),?,?)");
            statement.setInt(1,id_movie);
            statement.setString(2,title);
            statement.setInt(3,release_date);
            statement.setInt(4,duration);
            statement.setDouble(5,score);
            statement.execute();
            System.out.println("New row inserted");
            statement.close();
        }catch (SQLException exp){
            exp.printStackTrace();
        }
    }
   //gasesc un film cu ajutorul unui id dat
    public void findByAMovieId(int movie_id){
        try {
            PreparedStatement statement = database.connection.prepareStatement("Select * from movies where id_movie = ?");
            statement.setInt(1,movie_id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int movieId  = resultSet.getInt("id_movie");
                String MovieName = resultSet.getString("title");
                String releaseYear = resultSet.getString("release_date");
                int duration=resultSet.getInt("duration");
                int score=resultSet.getInt("score");
                System.out.println("Filmul "+MovieName + " cu Id-ul " + movieId + " aparut in data de:" + releaseYear+" cu durata de "+duration+" si scorul "+score);
            }
            resultSet.close();
        }
        catch (SQLException e){
            System.out.println("Nu s-a putut gasi filmul");
            e.printStackTrace();
        }
    }
    //afisez informatii despre un film ales
    @Override
    public void findByName(String name) throws NullPointerException {
        List<Movie> movies = new ArrayList<>();
        Movie newMovie;
        try{

            PreparedStatement statement=database.connection.prepareStatement("select * from movies where title = ?");
            statement.setString(1,name);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                newMovie=new Movie(resultSet.getInt(1), name, resultSet.getString(3),resultSet.getInt(4),resultSet.getDouble(5));
                movies.add(newMovie);}
            resultSet.close();
            statement.close();

           for(int i=0;i<movies.size();i++)
               System.out.println(movies.get(i));

        } catch (SQLException exp){
            exp.printStackTrace();
        }

    }
   //afisez toate filmele
    public void allMovies(){
        List<Movie> movies = new ArrayList<>();
        Movie newMovie;
        try{

            PreparedStatement statement=database.connection.prepareStatement("select * from movies");
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                newMovie=new Movie(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getDouble(5));
                movies.add(newMovie);}
            resultSet.close();
            statement.close();

            for(int i=0;i<movies.size();i++)
                System.out.println(movies.get(i));

        } catch (SQLException exp){
            exp.printStackTrace();
        }
    }
    //afisez actorii/directorii dintr-un film
    public void findActorByMovie(String title) {
        List<Person> persons=new ArrayList<>();
        Person newPerson;
        System.out.println("Filmul "+title+" are urmatorii actori: ");
        try{

            PreparedStatement statement=database.connection.prepareStatement("select person.id_pers,person.nume,person.prenume,person.gender,person.age from Person join actors on person.id_pers=actors.id_pers join movies on actors.id_movie=movies.id_movie where title = ?");
            statement.setString(1,title);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                newPerson=new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5));
                persons.add(newPerson);}
            resultSet.close();
            statement.close();
            if(persons.size()==0) System.out.println("Nu exista actori pentru acest film in baza de date");
            else
            for(int i=0;i<persons.size();i++)
                System.out.println(persons.get(i));

        } catch (SQLException exp){
            exp.printStackTrace();
        }
        System.out.println(" Si directori:");
        List<Person> personsDir=new ArrayList<>();
        Person newPersonDir;
        try{

            PreparedStatement statement=database.connection.prepareStatement("select person.id_pers,person.nume,person.prenume,person.gender,person.age from Person join directors on person.id_pers=directors.id_pers join movies on directors.id_movie=movies.id_movie where title = ?");
            statement.setString(1,title);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                newPersonDir=new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5));
                personsDir.add(newPersonDir);}
            resultSet.close();
            statement.close();
            if(personsDir.size()==0) System.out.println("Nu exista directori pentru acest film in baza de date");
            else
                for(int i=0;i<personsDir.size();i++)
                    System.out.println(personsDir.get(i));

        } catch (SQLException exp){
            exp.printStackTrace();
        }
    }
}
