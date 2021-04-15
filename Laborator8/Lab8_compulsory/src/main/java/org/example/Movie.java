package org.example;

import java.util.Date;

public class Movie {

        String name;
        int movieId;
        Date releaseDate;
        int duration;
        int score;

    public Movie(String name, int movieId, Date releaseDate, int duration, int score) {
        this.name = name;
        this.movieId = movieId;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public Movie(String name, int genreId) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
