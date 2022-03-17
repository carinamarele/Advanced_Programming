public class Solution {
    /**
     * <p>Construiesc un constructor gol pentru obiecte de tipul Solutii,nu am nevoie sa il initializez cu ceva</p>
     */
    public Solution() {
    }

    /**
     * <p>Creez un string pentru a afisa informatii despre solutii</p>
     * @return stringul cu datele necesare
     */
    @Override
    public String toString() {
        return "Solution{}";
    }

    Problem pb = new Problem();

    /**
     * <p>Aceasta metoda imi genereaza solutia problemei</p>
     * <p>Calculeaza suma Suppl si suma demand iar daca sumaSuppl e mai mica decat sumaDemand atunci imi va afisa ca nu exista solutii</p>
     * <p>Daca nu se incalca conditia de mai sus atunci se va incepe cu S1 si se va verifica daca este mai mic decat D1 si tot asa</p>
     * <p>Se ia valoarea cea mai mica si se inmulteste cu costul din matricea costurilor</p>
     */
    public void solutieBuna() {
        pb.rezolvProblem();
        System.out.println("");
        pb.printProblem();
        int costTotal = 0;
        int sumaSupplyTotal = 0, sumaDemandTotal = 0;
        for (int i = 0; i < pb.dimensiune; i++) {
            sumaDemandTotal += pb.destinatii.get(i).demand;
            sumaSupplyTotal += pb.surse.get(i).capacity;
        }

        if (sumaSupplyTotal < sumaDemandTotal)
            System.out.println("Nu exista solutii!! Supply<Demand [FALS]" + sumaSupplyTotal + " " + sumaDemandTotal);
        else {
            int j = 0;
            int i = 0;
            while ((pb.destinatii.get(j).demand != 0) && (j < pb.dimensiune - 1))
                if (pb.surse.get(i).capacity < pb.destinatii.get(j).demand) {
                    System.out.println(pb.surse.get(i).name + " - > " + pb.destinatii.get(j).name + ": " + pb.surse.get(i).capacity
                            + " units * cost " + pb.cost[i][j] + " = " + pb.surse.get(i).capacity * pb.cost[i][j]);
                    costTotal += pb.surse.get(i).capacity * pb.cost[i][j];
                    pb.destinatii.get(j).demand -= pb.surse.get(i).capacity;
                    pb.surse.get(i).capacity = 0;
                    i++;
                } else if (pb.surse.get(i).capacity > pb.destinatii.get(j).demand) {
                    System.out.println(pb.surse.get(i).name + " - > " + pb.destinatii.get(j).name + ": "
                            + pb.destinatii.get(i).demand + " units * cost " + pb.cost[i][j] + " = " + pb.surse.get(i).capacity * pb.cost[i][j]);
                    costTotal += pb.surse.get(i).capacity * pb.cost[i][j];
                    pb.surse.get(i).capacity -= pb.destinatii.get(j).demand;
                    pb.destinatii.get(j).demand = 0;
                    j++;
                } else if(pb.surse.get(i).capacity == pb.destinatii.get(j).demand){
                    System.out.println(pb.surse.get(i).name + " - > " + pb.destinatii.get(j).name + ": " +
                            pb.destinatii.get(j).demand + " units * cost " + pb.cost[i][j] + " = " +
                            pb.destinatii.get(j).demand * pb.cost[i][j]);
                    costTotal += pb.destinatii.get(j).demand * pb.cost[i][j];
                    pb.destinatii.get(j).demand = 0;
                    pb.surse.get(i).capacity = 0;
                    i++;
                    j++;
                }
        }
        System.out.println("Costul total este: " + costTotal);
    }

}





