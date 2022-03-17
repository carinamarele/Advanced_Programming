import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class City {
    public String name;
    protected List<Location> locatii =new ArrayList<>();

    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";
    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Orasul " + name +
                " are urmatoarele locuri de vizitat" + locatii +
                '}';
    }

    /**
     * <p>Prin aceasta functie mi se creaza lista cu locurile vizitabile si nu platibile ordonate in functie de ora de deschidere</p>
     */
    public void VisitHour(){
        List<Location> vizitabile = new ArrayList<>();
        for(int i=0;i<this.locatii.size();i++)
               //prin liniile 33 si 34 verific care fac parte din clasa visitable si care nu fac parte din clasa payable
            if(locatii.get(i) instanceof Visitable)
                if(!(locatii.get(i) instanceof Payable)){
                    vizitabile.add((locatii.get(i)));
                }
        //folosesc clasa Comporator pentru a ordona lista in functie de ora de deschidere
        vizitabile.sort(Comparator.comparing(Location::toString));
                for(int i=0;i<vizitabile.size();i++)
                    System.out.println(vizitabile.get(i));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(locatii, city.locatii);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, locatii);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Location> getLocatii() {
        return locatii;
    }

    public void setLocatii(List<Location> locatii) {
        this.locatii = locatii;
    }
}

