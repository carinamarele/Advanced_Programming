package org.example;

public class Daemon implements Runnable {
    //valorea default in caz de nu este data o valoare
    float timeToWaitSeconds = 10;
    private boolean isRunnable = true;


    public Daemon() {
    }

    public Daemon(float timeToWaitSeconds) {
        this.timeToWaitSeconds = timeToWaitSeconds;
    }
   //Un timp dat pentru desfasurarea jocului, daca se termina si jucatorii inca joaca se va opri aplicatia
    @Override
    public void run() {
        long Start = System.nanoTime();
        long End = System.nanoTime();

        while((End - Start)/1_000_000_000 <= timeToWaitSeconds && isRunnable) {
            End = System.nanoTime();
        }

        System.out.println("GATA ASTEPTAREA");

        Game.getInstance().stopGame();
    }

    public void setRunnable(boolean runnable) {
        isRunnable = runnable;
    }
}
