package org.example;

public class Token {
    private int xFirst;
    private int ySecind;
    private int costValue;

    public Token(int xFirst, int ySecind, int costValue) {
        this.xFirst = xFirst;
        this.ySecind = ySecind;
        this.costValue = costValue;
    }

    public int getxFirst() {
        return xFirst;
    }

    public void setxFirst(int xFirst) {
        this.xFirst = xFirst;
    }

    public int getySecind() {
        return ySecind;
    }

    public void setySecind(int ySecind) {
        this.ySecind = ySecind;
    }

    public int getCostValue() {
        return costValue;
    }

    public void setCostValue(int costValue) {
        this.costValue = costValue;
    }
}