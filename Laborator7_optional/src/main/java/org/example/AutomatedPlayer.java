package org.example;

public class AutomatedPlayer extends Player{

    public AutomatedPlayer(String name, int order) {
        super(name, order);
    }

    /**
     * <p>Robotul sau playerul automat va lua random un token disponibil din matrice pe care il va adauga in lista lui de tokenuri pentru a calcula scorul la final</p>
     */
    @Override
    void playGame() {
        Board board = Game.getInstance().getBoard();
        try {
            //luam un token random de pe tabla si il salvam in lista playerului robot
            Token token = Game.getInstance().getBoard().takeRandomToken();
            tokenList.add(token);
        } catch (NoTokenException | InterruptedException e) {
            isRunning = false;
        }
    }
}