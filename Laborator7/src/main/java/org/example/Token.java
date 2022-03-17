package org.example;

// tokenurile pe care le folosim pe tabla
public class Token {
    private boolean spaceBlank;
    private int number;

    public Token(int number) {
        this.number = number;
        this.spaceBlank = false;
    }

    public Token() {
        this.spaceBlank = true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isSpaceBlank() {
        return spaceBlank;
    }

    public void setSpaceBlank(boolean blank) {
        this.spaceBlank = blank;
    }
}

