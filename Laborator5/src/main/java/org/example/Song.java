package org.example;

public class Song extends Item {
    public static final String COLOR = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    private String genre;
    private int numberOfLikes;

    /**
     * <p>Constructor care imi preia numele,id-ul si path-ul din clasa parinte si initializeaza restul atributelor</p>
     *
     * @param name          - numele obiectului
     * @param id            - id-ul obiectului
     * @param path          - path-ul la care se gaseste obiectul
     * @param genre         - genul obiectului
     * @param numberofLikes - numarul de like-uri in primele 24h
     */
    public Song(String name, String id, String path, String genre, int numberofLikes) {
        super(name, id, path);

        this.genre = genre;
        this.numberOfLikes = numberofLikes;
    }

    //settere si gettere pentru restul atributelor
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumberOfStars() {
        return numberOfLikes;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfLikes = numberOfStars;
    }

    /**
     * <p>Afiseaza informatii despre melodia creata</p>
     *
     * @return - un string cu datele necesare
     */
    @Override
    public String toString() {
        return COLOR + "Melodia " + RESET +
                getName() +
                ", cu id-ul " + getId() + ", genul " + genre +
                ", cu un numar de " + numberOfLikes + " like-uri si se gaseste in " + getPath();
    }
}
