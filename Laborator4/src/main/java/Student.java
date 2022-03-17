import java.util.ArrayList;
import java.util.List;

public class Student {

    //Adaug culori la tipurile obiectelor create pentru a citi mai usor
    public static final String COLOR = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    private String name;
    private List<School> preferinte = new ArrayList<>();

    public Student(String nume) {
        this.name = nume;
    }
    //Mai jos am gettere si settere pentru a prelua si prelucra atributele private
    public List<School> getPreferinte() {
        return preferinte;
    }

    public void setPreferinte(List<School> preferinte) {
        this.preferinte.addAll(preferinte);
    }

    public String getName() {
        return name;
    }

    public void setName(String nume) {
        this.name = nume;
    }

    /**
     * <p>Creez un string in care voi pune toate informatiile despre obiectele create,cum ar fi numele si lista ei de preferinte</p>
     * @return un string cu informatiile despre obiectul creat
     */
    @Override
    public String toString() {
        String text = ("preferinte de scoli: ");
        text = text + this.name + ": ";
        for (int i = 0; i < this.getPreferinte().size(); i++) {
            text = text + this.getPreferinte().get(i).getName();
            if (this.getPreferinte().size() >= 0 && i < this.getPreferinte().size() - 1) {
                text = text + ", ";
            }
        }
        return COLOR + "Studentul " + RESET +
                name +  " are urmatoarele " +
                text + ".";
    }
}
