/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Arrays;

/**
 *
 * @author Carina
 */
public class Problem {

    public Source[] sources;
    public Destination[] destinations;
    public int suply[];
    public int demand[];
//settere pentru atribuirea informatiilor
    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public void setDestinations(Destination[] destinations) {
        this.destinations = destinations;
    }

    public void setSuply(int[] suply) {
        this.suply = suply;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }
   //gettere pentru preluarea informatiilor
    public Source[] getSources() {
        return sources;
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public int[] getSuply() {
        return suply;
    }

    public int[] getDemand() {
        return demand;
    }

    public Problem(Source[] sources, Destination[] destinations, int[] suply, int[] demand) {//constructorul care initializeaza atributele clasei
        this.sources = sources;
        this.destinations = destinations;
        this.suply = suply;
        this.demand = demand;
    }

    @Override
    public String toString() {//afiseaza toate atributele unui obiect din clasa respectiva,se autoapeleaza cand printezi ceva
        return "Problem{" + " sources = " + Arrays.toString(sources) + ", destinations = " + Arrays.toString(destinations) + ", suply = " + Arrays.toString(suply) + ", demand = " + Arrays.toString(demand) + '}';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declaram obiecte de tipul sursa ,destinatie si le initializam
        Source S1 = new Source("S1", SourceType.FACTORY, 10);
        Source S2 = new Source("S2", SourceType.FACTORY, 35);
        Source S3 = new Source("S3", SourceType.FACTORY, 30);

        Destination D1 = new Destination("D1", 20);
        Destination D2 = new Destination("D2", 25);
        Destination D3 = new Destination("D3", 25);
// creem matricea pentru costuri,punand valori random intre [2,13]* si o si afisam in acelasi timp
        int[][] cost = new int[4][4];
        int i, j;
        for (i = 1; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                cost[i][j] = (int) (Math.random() * 12 + 2);
                System.out.print(cost[i][j] + " ");
            }
            System.out.println("");
        }
        //afisez detalii despre obiectele create,apelandu-se toString din clasele Source,Destination
        System.out.println(S1);
        System.out.println(S2);
        System.out.println(S3);
        System.out.println(D1);
        System.out.println(D2);
        System.out.println(D3);
    }

}
