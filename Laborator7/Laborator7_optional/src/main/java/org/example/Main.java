package org.example;

/**
 * <p>Metoda main unde declar 2 jucatori, pot fi ambii jucatori normali sau poti juca si cu un robot care alege random</p>
 * @author Carina Marele
 */
public class Main
{
    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new HumanPlayer("Carina", 0);
        players[1] = new AutomatedPlayer("Ioana Bot", 1);
        //players[1] = new HumanPlayer("Ionela", 1);
        try {
            Game.getInstance().initGame(6, 10, players, 100);
        } catch (WrongNumberOfPlayers | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
