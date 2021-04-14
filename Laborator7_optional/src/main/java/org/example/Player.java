package org.example;

import java.util.LinkedList;
import java.util.List;

public abstract class Player implements Runnable {

    private String name;
    protected List<Token> tokenList = new LinkedList<Token>();
    protected boolean isFirstPlayer = false;
    protected int order; // reprezinta indicele jucatorului(voi avea 0 sau 1)

    boolean isRunning = true;//prin el vad daca ruleaza


    public Player(String name, int order) {
        this.name = name;
        this.order = order;
        if (order == 0) //daca este primul jucator va incepe el
            this.isFirstPlayer = true;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(name + " a inceput sa joace!");

        Game game = Game.getInstance();

        //cat timp nu s-a terminat jocul
        while (isRunning) {
            while (isRunning && (game.getTurn() != order)) {

                //folosit pentru a putea sincroniza threadurile, este eliberat cand isi termina treaba threadul
                synchronized (game) {
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        isRunning = false;
                    }
                }
            }
            playGame();

            game.changeTurn();
        }

        System.out.println(name + " a terminat jocul!");
    }

    public void stopPlaying() {
        isRunning = false;
    }

    public int calculateScore() {
        /*
            Aflam componentele conexe
            Scorul o sa fie suma valorilor tokenurilor + (cel mai mare token ales) * numarul de noduri din cea mai mare
            component conexa
         */
        int sum = 0;
        int max = 0;
        // aleg cel mai mare token din lista playerului si il retin
        for (Token token : tokenList) {
            sum += token.getValue();
            if (token.getValue() > max) max = token.getValue();
        }

        int N = Game.getInstance().getBoard().getN(); //lungimea de n tokenuri de pe tabla
        int[][] matriceAdiacenta = new int[N][N];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                matriceAdiacenta[i][j] = 0;
            }
        }

        for (Token token : tokenList) {
            //iau valorile din lista de perechi de tokenuri
            int i = token.getFirst();
            int j = token.getSecond();
            matriceAdiacenta[i][j] = matriceAdiacenta[j][i] = 1;
        }
        int maximumOfNodes = 0;
        boolean[] visited = new boolean[N];

        for (int i = 0; i < visited.length; ++i) {
           //cat timp nu este vizitat voi apela bts pe matricea mea de adiacenta,lista de noduri vizitate si pozitia adica nodul i
            if (!visited[i]) {
                //imi va returna numarul de noduri dintr-o componenta conexa
                int nodes = BFS.BFSAlgoritm(matriceAdiacenta, visited, i);//trimit matricea de adicenta, lista cu nodurile vizitate si pozitia de unde voi incepe parcurgerea BFS
                if (nodes > maximumOfNodes) maximumOfNodes = nodes;//retinem daca este o valoare maxima
            }
        }

        return sum + max * maximumOfNodes;
    }

    abstract void playGame();//metoda abstracta rescrisa in humanplayer si automatedplayer

    public String getTokenList() {
        StringBuilder builder = new StringBuilder();//folosesc un stringbuilder pentru a pune intr-un string informatii, si ma folosesc de append care imi pune la fianlul sirului niste caractere

        tokenList.forEach(token -> { builder.append(token.toString());
                                     builder.append(" ");
                                   });
        //pentru fiecare token din lista ma voi folosi de builder care ma ajuta sa modific ce voi afisa si la final voi afisa builder-ul
        // imi afisez prin ea perechile ( i_1,i_2) (i_2,i_3) ...
        return builder.toString();
    }
}