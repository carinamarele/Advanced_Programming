package org.example;

/**
 * Hello world!
 *
 */
public class App implements Runnable
{
    public static void main( String[] args )
    {Player[] players = new Player[10];
     int numberPlayers=(int)(Math.random()*8+2);
     for(int i=1;i<=numberPlayers;i++)
     {
         String numePlayer=new String("nume");
         numePlayer.concat(String.valueOf(i));
         players[i]=new Player(i,numePlayer);
     }

    }

    @Override
    public void run() {

    }
}
