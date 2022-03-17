import java.util.ArrayList;
import java.util.List;

public class Problem {
    public int dimensiune = (int) (Math.random() * 5 + 1);
    public int[][] cost = new int[dimensiune][dimensiune];
    public List<Source> surse = new ArrayList<>();
    public List<Destination> destinatii = new ArrayList<>();

    /**
     * <p>Constructor pentru obiecte de tipul Problem,nu este nevoie intializarea acestuia</p>
     */
    public Problem() {
    }

    /**
     * <p>Initializez obiecte de tipul Destination si Source</p>
     * <p>Generez la final si matricea de costuri random</p>
     */
    public void rezolvProblem() {
        for (int i = 0; i < dimensiune; i++) {
            int type = (int) (Math.random()*2);
            int capacitate = (int) (Math.random() * 55 + 5);
            String numeSursa ="S";
            int id = i + 1;
            numeSursa = numeSursa.concat(String.valueOf(id));
            if (type == 0) {
                Factories S1 = new Factories(numeSursa, capacitate);
                surse.add(S1);
            } else {
                Warehouse W1 = new Warehouse(numeSursa, capacitate);
                surse.add(W1);
            }
            int comoditate = (int) (Math.random() * 55 + 5);
            String numeDestinatie = "D";
            numeDestinatie = numeDestinatie.concat(String.valueOf(id));
            Destination D1 = new Destination(numeDestinatie, comoditate);
            destinatii.add(D1);
        }
        for (int i = 0; i < dimensiune; i++)
            for (int j = 0; j < dimensiune; j++) {
                cost[i][j] = (int) (Math.random() * 10 + 2);
            }
    }

    /**
     * <p>Aceasta imi printeaza atat matricea de costuri cat si obiectele cu toate informatiile despre ele</p>
     */
    public void printProblem() {
        for(int i=0;i<dimensiune;i++)
        {    System.out.println(surse.get(i));
            System.out.println(destinatii.get(i));}
        System.out.print("  | ");
        for(int i=0;i< dimensiune;i++)
            System.out.print("D"+String.valueOf(i+1)+" ");
        System.out.println("");
        System.out.print("-----");
        for(int i=0;i< dimensiune;i++)
            System.out.print("---");
        System.out.println("");
        for(int i=0;i< dimensiune;i++) {
            System.out.print("S" + String.valueOf(i + 1) + "| ");
            for(int j=0;j<dimensiune;j++)
            {
                System.out.print(cost[i][j]+" ");
            }
            System.out.println("");
        }
    }


}
