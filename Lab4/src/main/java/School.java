import java.util.ArrayList;
import java.util.List;

public class School implements Comparable{

    //Adaug culori la tipurile obiectelor create pentru a citi mai usor
    public static final String COLOR = "\u001B[32m";
    public static final String RESET = "\u001B[0m";


    private String name;
    private List<Student> preferinte = new ArrayList<>();
    private int capacitate;
    //Mai jos am gettere si settere pentru a prelua si prelucra atributele private
    public School(String name, int capacitate) {
        this.name = name;
        this.capacitate = capacitate;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public List<Student> getPreferinte() {
        return preferinte;
    }

    public void setPreferinte(List<Student> preferinte) {
        this.preferinte.addAll(preferinte);
    }

    public String getName() {
        return name;
    }

    /**
     * <p>Creez un string in care voi pune toate informatiile despre obiectele create,cum ar fi numele si lista ei de preferinte</p>
     * @return un string cu informatiile despre obiectul creat
     */
    @Override
    public String toString() {
        String text = ("preferinte de studenti:  ");
        text = text + this.name + ": ";
        int marime = this.getPreferinte().size();
        for (int i = 0; i < marime; i++) {
            text = text + this.getPreferinte().get(i).getName();
            if (marime >= 0 && i < marime - 1) {
                text = text + ", ";
            }
        }
        return COLOR + "Scoala " + RESET +
                name + " are urmatoarele " +
                text + ".";
    }
    public void setName(String nume) {
        this.name = nume;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
