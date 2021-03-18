package org.example;

public class Book extends Item {
    public static final String COLOR = "\u001B[35m";
    public static final String RESET = "\u001B[0m";
    private String genre, author;
    private int rating;

    /**
     * <p>Constructor care imi preia numele,id-ul si path-ul din clasa parinte si initializeaza restul atributelor</p>
     *
     * @param name   - numele cartii
     * @param id     - id-ul cartii
     * @param path   - path-ul la care se gaseste cartea
     * @param genre  - genul cartii
     * @param author - autorul cartii
     * @param rating - ratingul din cele 5 stele ale cartii
     */
    public Book(String name, String id, String path, String genre, String author, int rating) {

        super(name, id, path);
        this.genre = genre;
        this.author = author;
        this.rating = rating;
    }

    //gettere si settere pentru preluarea si prelucrarea datelor obiectelor
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * <p>Afiseaza informatii despre melodia creata</p>
     *
     * @return - un stirng cu datele necesare
     */
    @Override
    public String toString() {
        return COLOR + "Cartea " + RESET +
                getName() + ", scrisa de " + author +
                ", cu id-ul " + getId() + ", genul " + genre +
                ", cu ratingul de " + rating + " si se gaseste in " + getPath();
    }
}
