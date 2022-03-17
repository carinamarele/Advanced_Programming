package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    List<Token> tokens = new ArrayList<>();
    int tokenNumber;

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public Board(){
        init();
    }

    void init(){
        tokenNumber=(int) (Math.random()*8+1);
        int maximumNumberPairs=tokenNumber*(tokenNumber-1)/2;
        System.out.println(tokenNumber);
        for(int i=1;i<=maximumNumberPairs;i++)
        {
            int x=(int) (Math.random()*tokenNumber+1);
            int y=(int)(Math.random()*tokenNumber+1);
            while(x==y){
                y=(int)(Math.random()*25);
            }
            int cost=(int) (Math.random()*25);
            Token newToken=new Token(x,y,cost);
            tokens.add(newToken);
        }
    }
}