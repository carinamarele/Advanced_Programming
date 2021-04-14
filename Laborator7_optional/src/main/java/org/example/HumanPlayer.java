package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, int order) {
        super(name, order);
    }

    @Override
    void playGame() {
        Board board = Game.getInstance().getBoard();
        int nbTokens = board.getNumberOfAvailableTokens();//numarul de tokenuri disponibile pentru a sti cand se termina jocul
        if(nbTokens == 0) {//daca nu mai am oprim jocul
            isRunning = false;
            return;
        }
        System.out.println(board.getBoardAsString());
        System.out.println("Your tokens: " + getTokenList()); //afisez ce am pana acum in lista de tokenuri
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); //pentru a putea citi de la tastatura

        boolean isTakenToken = false;
        while(!isTakenToken && isRunning) {
            int linie, coloana;
            try {
                System.out.print("Linia: ");
                //luam valorile din terminal
                linie = Integer.parseInt(input.readLine().trim());
                System.out.print("\n Coloana: ");
                coloana = Integer.parseInt(input.readLine().trim());
            } catch (IOException e) {
                continue;
            }

            if(!isRunning) return; //daca am terminat se opreste jocul


            try {
                Token token = board.getToken(linie, coloana);//luam tokenul si il punem in lista,daca linie si coloana nu sunt bune imi va arunca exceptie
                isTakenToken = true;
                tokenList.add(token);
            } catch (IndexOutOfBounds indexOutOfBounds) {
                System.out.println("Pozitie incorecta, ai iesit din matrice, te rog da o pozitie din intervalul matricei");
            } catch (NoTokenException e) {
                System.out.println("Nu exista token pe aceasta pozitie...");
            }
        }
    }
}