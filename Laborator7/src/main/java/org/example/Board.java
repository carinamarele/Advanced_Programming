package org.example;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Tabla de joc care contine lista cu tokenuri creata in Game</p>
 */
public class Board {
    private List<Token> tokenList;

    public Board(ArrayList<Token> tokensList) {
        this.tokenList = tokensList;
    }

    public ArrayList<Token> getTokenList() {
        return (ArrayList<Token>) tokenList;
    }

    public void setTokenList(ArrayList<Token> tokenList) {
        this.tokenList = tokenList;
    }
}
