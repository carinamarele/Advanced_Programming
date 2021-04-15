package org.example;


import java.sql.*;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class MovieController {
    private Connection con;

    public MovieController(Connection con) {
        this.con = con;
    }


    public void create(int id_movie, String title, Date release_date, int duration, int score) {
        try {
            PreparedStatement pstm = con.prepareStatement("Insert into movie (id,tile,release_date,duration,score) values(?,?,?,?,?)");
            pstm.setInt(1, id_movie);
            pstm.setString(2, title);
            pstm.setDate(3, release_date);
            pstm.setInt(4, duration);
            pstm.setInt(5, score);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Nu s-a putut realiza adaugarea unui nou album");
            e.printStackTrace();
        }
    }

    public void findByArtistId(int id_movie) {
        try {
            PreparedStatement pstm = con.prepareStatement("Select * from movie where id_movie = ?");
            pstm.setInt(1, id_movie);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idMovie = rs.getInt("id_movie");
                String titleMovie = rs.getString("title");
                int scoreMovie = rs.getInt("score");
                int duration = rs.getInt("duration");
                Date releaseDate = rs.getDate("release_date");
                System.out.println("Filmul cu numele: " + titleMovie + " cu Id-ul:" + idMovie + " aparut in data de:" + releaseDate + " cu durata de " + duration + " si are scorul " + scoreMovie);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Nu s-a putut gasi filmul");
            e.printStackTrace();
        }
    }

    private int getNumberOfMovies() {
        int numberOfMovies = 1;
        try {
            PreparedStatement pstm = con.prepareStatement("Select count(*) from Movies");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                numberOfMovies = rs.getInt(1);
            }

            rs.close();

        } catch (SQLException e) {
            System.out.println("Nu s-a obtine numarul de albume");
            e.printStackTrace();
        }
        return numberOfMovies;
    }

    public String getMovieNameByID(int id_movie) {
        String titleMovie = new String();
        try {
            PreparedStatement pstm = con.prepareStatement("Select * from movie where id_movie = ?");
            pstm.setInt(1, id_movie);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                titleMovie = rs.getString("title");

            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Nu se poate extrage filmul cu id-ul dat");
            e.printStackTrace();
        }
        return titleMovie;
    }

    private int getMinId() {
        int minId = 1;
        try {
            PreparedStatement pstm = con.prepareStatement("Select min(id_movie) from movie");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                minId = rs.getInt(1);
            }

            rs.close();

        } catch (SQLException e) {
            System.out.println("Nu se poate obtine id-ul minim");
            e.printStackTrace();
        }
        return minId;
    }

    private int getMaxId() {
        int maxId = 1;
        try {
            PreparedStatement pstm = con.prepareStatement("Select max(id_movie) from movie");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                maxId = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Nu s-a putut obtine id-ul maxim");
            e.printStackTrace();
        }
        return maxId;
    }


    public String[] getListOfMovie() {
        int numberOfMovie = 10;
        int movieId;
        int minId = getMinId();
        int maxId = getMaxId();
        List<String> movies = new ArrayList<>();
        String[] movieList = new String[numberOfMovie];
        int i = 0;
        while (i < numberOfMovie) {
            movieId = (int) (Math.random() * (maxId - minId));
            if (!movies.contains(this.getMovieNameByID(movieId))) {
                movies.add(this.getMovieNameByID(movieId));
                i++;
            }
        }
        Arrays.sort(movieList);
        return movieList;
    }
}