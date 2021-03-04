/**
 * @version %I% %G%
 * @author Carina Marele
 */
public class Main {
    /**
     * <p>Dupa ce se creeaza o instanta pentru problema data se va incepe rularea programului pentru a vedea cat dureaza si ce memorie are.</p>
     * <p>Se va afisa instanta creata cat si o rezolvare pentru ea</p>
     * <p>La finalul programului se vor afisa date despre timp si memorie</p>
     * @param args args care reprezinta parametrii cititi din linia de comanda,dar nu se folosesc in aceasta problema
     */
    public static void main(String[] args){
        long start=System.currentTimeMillis();
        Solution solutie=new Solution();
        System.out.println("");
        solutie.solutieBuna();
        System.out.println(" ");
        System.out.println("Date despre program");
        Runtime runtime=Runtime.getRuntime();
        runtime.gc();
        long memorie;
        memorie=runtime.totalMemory()-runtime.freeMemory();
        System.out.println("Memoria folosita:   "+memorie+" bytes");
        memorie=memorie/(1024L*1024L);
        System.out.println("Memoria folosita:   "+memorie+" MB");
        long stop=System.currentTimeMillis();
        System.out.println("Timpul programului este de "+(stop-start)+"milisecunde");

    }
}
