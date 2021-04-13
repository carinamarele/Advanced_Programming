package org.example;
import java.util.Random;

/**
 * <p>Fiecare player are un nume,iar acesta apartine unei table de joc</p>
 */
public class Player implements Runnable {
    private String name;
    private Board playBoard;

//Constructor
    public Player(String name, Board playBoard) {
        this.name = name;
        this.playBoard = playBoard;
    }
//settere si gettere
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getPlayBoard() {
        return playBoard;
    }

    public void setPlayBoard(Board playBoard) {
        this.playBoard = playBoard;
    }

    /**
     * <p> Run se foloseste la threaduri</p>
     * <p> Alegem random un token din lista de tokenuri si verificam mereu daca mai sunt tokenuri,daca nu mai sunt spunem ca a castigat playerul care urma sa traga, altfel continua sa traga</p>
     */
    @Override
    public void run() {
        try {
            Random rand = new Random();
            Token pickedToken = playBoard.getTokenList().get(rand.nextInt(playBoard.getTokenList().size()));
            playBoard.getTokenList().remove(pickedToken);
            if (playBoard.getTokenList().size() == 0) {
                System.out.println("Playerul " + this.name + " a castigat! Felicitari!");
            } else {
                System.out.println("Playerul " + this.name + " trage numarul " + pickedToken.getNumber());
            }
        } catch (Exception e) {
            System.out.println("!! Nu avem tokenuri !!");
        }
    }
}
