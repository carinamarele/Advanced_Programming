package org.example;


public class Genre{
    String name;
    int  id_genre;

    public Genre(String name, int id_genre) {
        this.name = name;
        this.id_genre = id_genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }
}