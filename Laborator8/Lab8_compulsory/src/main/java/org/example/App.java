package org.example;
import com.github.javafaker.Faker;

import java.sql.*;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException {
        try {
            Database movieGenres = Database.getInstance();
            Statement stmt = movieGenres.con.createStatement();

            MovieController movieController = new MovieController(movieGenres.con);
            GenreController genreController = new GenreController(movieGenres.con);
            String name = new String();
            for (int i = 1; i <= 20; i++) {
                Faker faker = new Faker();
                Genre newGenre = new Genre(faker.name().name(), faker.address().id_genre());
                genreController.create( newGenre.getId_genre(),newGenre.getName());
                name = newGenre.getName();
            }
            int minIdGenre = genreController.getMinId();
            int maxIdGenre = genreController.getMaxId();
            int genreIdSearch = 1;

            for (int i = 1; i <= 35; i++) {
                Faker faker = new Faker();
                int genreId = faker.number().numberBetween(minIdGenre, maxIdGenre);
                Movie newMovie = new Movie(faker.pokemon().name(), genreId);
                MovieController.create(newMovie.getMovieId(),newMovie.getName(),newMovie.getReleaseDate(), newMovie.getDuration(),newMovie.getScore());
                genreIdSearch = genreId;
            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
