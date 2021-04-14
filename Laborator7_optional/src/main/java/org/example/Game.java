package org.example;

public class Game {
    private static Game instance;//daca a inceput sau nu jocul

    private Board board;//tabla de joc

    private int turn = 0;// a cui este randul

    private Player firstPlayer;
    private Player secondPlayer;

    private Game() {

    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();//daca este null inseamna ca nu a inceput jocul si cream unul,altfel returnam instanta jocului
        }
        return instance;
    }

    public Board getBoard() {
        return board;
    }


    public void initGame(int n, int maxValue, Player[] players, float timeInSeconds) throws WrongNumberOfPlayers, InterruptedException {
        //daca numarul de jucatori este mai mare de 2 atunci nu putem juca
        if(players.length != 2)
            throw new WrongNumberOfPlayers("Nu pot fi mai mult de 2 jucatori");
        // preluam jucatorii
        firstPlayer = players[0];
        secondPlayer = players[1];
        //cream tabla de nxn si valoarea maxima din ea
        board = new Board(n, maxValue);
        Thread firstPlayerThread = new Thread(firstPlayer);
        Thread secondPlayerThread = new Thread(secondPlayer);
        Daemon daemon = new Daemon(timeInSeconds);
        Thread daemonThread = new Thread(daemon);

        firstPlayerThread.start();
        secondPlayerThread.start();
        daemonThread.start();

        firstPlayerThread.join();

        secondPlayerThread.join();

        daemon.setRunnable(false);

        System.out.println(players[0].getName() + ":"  + players[0].getTokenList());

        System.out.println("Scorul lui " + players[0].getName() + " : " +  players[0].calculateScore());

        System.out.println(players[1].getName() + ":"  + players[1].getTokenList());

        System.out.println("Scorul lui " + players[1].getName() + " : " +  players[1].calculateScore());

        if(players[0].calculateScore()>players[1].calculateScore())
            System.out.println(players[0].getName()+ " a castigat!");
        else System.out.println(players[1].getName() + " a castigat!");
    }

    //oprim jocul oprind turele jucatorilor
    public void stopGame() {
        firstPlayer.stopPlaying();
        secondPlayer.stopPlaying();
    }


    public synchronized int getTurn() {
        return turn;
    }

    /**
     * <p>Metoda sincronizata pentru schimbarea turei</p>
     */
    public synchronized void changeTurn() {
        turn = (turn + 1) % 2;
        notifyAll();
    }

}
