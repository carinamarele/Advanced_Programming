package org.example;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Board {

    private static Board instance;
    private boolean isAvailable = true;

    Token[][] tokens;
    int n;


    public Board(int n, int maxValue) {
        init(n, maxValue);
    }

    private void init(int n, int maxValue) {
        tokens = new Token[n][n];
        Random r = new Random();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;//pe diagonala principala nu voi pune tokenuri
                tokens[i][j] = new Token(i, j, 1 + r.nextInt(maxValue));
            }
        }
    }


    /**
     * <p>Preiau un token random de pe tabla</p>>
     * <p> Voi face o metoda sincronizata pentru a putea lucra cu threadurile si pentru a exista concurenta</p>
     * @return tokenul random
     * @throws NoTokenException exceptie pentru atunci cand nu gaseste token
     * @throws InterruptedException exceptie aruncata daca un thread este intrerupt
     */
    public synchronized Token takeRandomToken() throws NoTokenException, InterruptedException {
        /**
         * <p>Creez o clasa pentru a retine mai usor indicii pentru tokenuri, ma voi folosi de acesti indecsi la cautarea tokenurilor pe tabla</p>
         */
        class IndexPair {
            public int i;
            public int j;

            public IndexPair(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
        //Creez o lista pentru tokenuri unde retinem indicii
        List<IndexPair> tokenList = new LinkedList<>();
        //voi adauga in tokenList perechea i,j  daca tokenul de la pozitia respectiva nu este null
        // cu i si j voi merge pana la numarul total de tokenuri
        for (int i = 0; i < tokens.length; ++i) {
            for (int j = 0; j < tokens.length; ++j) {
                if (tokens[i][j] != null) {
                    tokenList.add(new IndexPair(i, j));
                }
            }
        }

        if (tokenList.size() == 0)
            throw new NoTokenException("Nu este disponibil vreun token");// adica s-au extras toate

        Random random = new Random();

        int index = random.nextInt(tokenList.size());// retin un numar random intre 0 si dimensiunea listes de tokenuri(indici)

        IndexPair indexPair = tokenList.get(index);//iau indicii de la pozitia index din tokenList


        Token copy = tokens[indexPair.i][indexPair.j];//fac o copie pentru a putea o sterge dar sa o retin dupa in lista robotului de tokenuri

        tokens[indexPair.i][indexPair.j] = null;
        return copy;
    }
// returnez numarul de tokenuri
    public synchronized int getN() {
        return tokens.length;
    }
//afisez tabela actualizata dupa fiecare mutare
    public synchronized String getBoardAsString() {
        StringBuilder sb = new StringBuilder();// voi folosi un stringbuilder pentru a afisa tabela
        sb.append("  ");

        //afisez pozitiile pentru coloana 0 1 2......
        for (int i = 0; i < tokens.length; ++i) {
            sb.append(i);
            sb.append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < tokens.length; ++i) {
            sb.append(i);// prima data afisez pozitia din stanga a liniei
            //dupa incep sa afisez valorile propriu zise a tokenurilor
            for (int j = 0; j < tokens[0].length; ++j) {
                sb.append(" ");
                if (tokens[i][j] != null) //daca este il afisez iar daca este null voi afisa '-'
                    sb.append(tokens[i][j].getValue());
                else
                    sb.append("-"); // de fiecare data cand se va lua un token din matrice se va inlocui cu '-'
            }
            sb.append("\n");
        }

        return sb.toString();//afisez tot ce am salvat in sb
    }

    /**
     * <p> Metoda sincronizata pentru threaduri pentru a sti mereu cate tokenuri mai sunt disponibile</p>
     * @return numarul de tokenuri ramase
     */
    public synchronized int getNumberOfAvailableTokens() {
        int number = 0;
        for (int i = 0; i < tokens.length; ++i) {
            for(int j = 0; j < tokens.length; ++j) {
                if(tokens[i][j] != null)
                    number++;
            }
        }
        return  number;
    }

    /**
     * <p>Metoda sincronizata pentru threaduri pentru a lua tokenul de pe tabela</p>
     * @param i pozitia de pe linie
     * @param j pozitia de pe coloana
     * @return tokenul pe care vrem sa il luam de pe tabela
     * @throws IndexOutOfBounds exceptie aruncata cand se da un index in afara intervalului tabelei
     * @throws NoTokenException exceptie aruncata cand nu exista token la pozitia data, adica a fost deja luat sau e pe diagonala principala
     */
    public synchronized Token getToken(int i, int j) throws IndexOutOfBounds, NoTokenException {
        if(i < 0 || i >= tokens.length || j < 0 || j >= tokens.length)
            throw new IndexOutOfBounds("Ups, ai gresit indexul, verifica-l din nou!");

        if(tokens[i][j] == null)
            throw new NoTokenException("Nu gasesti niciun token aici!");

        Token copy = tokens[i][j];

        tokens[i][j] = null;

        return copy;
    }

}
