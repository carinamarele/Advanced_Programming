package org.example;
import java.util.ArrayList;

/**
 * <p>Prima data imi iau doua liste, una pentru tokenuri si una pentru scoruri</p>
 * <p>Dupa imi adaug in lista de tokenuri numere de la 1 la 20(un numar dat de mine) si creez dupa tabla de joc cu lista creata</p>
 * <p>Creez doi playeri, cu nume dat de mine si ii pun pe tabla de joc</p>
 * <p> Creez pe final threadurile pentru concurenta</p>
 */
public class Game {
    public Game() throws InterruptedException {
        ArrayList<Token> tokens = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            tokens.add(new Token(i));
        }
        Board newBoard = new Board(tokens);

        Runnable firstPlayer = new Player("Ilie", newBoard);
        Runnable secondPlayer = new Player("Ioana", newBoard);
        while (newBoard.getTokenList().size() > 1) {
            new Thread(firstPlayer).start();
            new Thread(firstPlayer).sleep((long) 100.0);
            new Thread(secondPlayer).start();
        }
        System.out.println();
    }
}