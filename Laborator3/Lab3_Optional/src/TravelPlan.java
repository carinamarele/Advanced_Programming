import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TravelPlan {
    private City oras;
    List<Location> preference = new ArrayList<>();

    public TravelPlan() {
    }

    @Override
    public String toString() {
        return "TravelPlan [" +
                "oras=" + oras +
                ", preference=" + preference +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelPlan that = (TravelPlan) o;
        return Objects.equals(oras, that.oras) && Objects.equals(preference, that.preference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oras, preference);
    }

    public String getOras() {
        return oras.getName();
    }

    public void setOras(City oras) {
        this.oras = oras;
    }

    public List<Location> getPreference() {
        return preference;
    }

    public void setPreference(List<Location> preference) {
        this.preference = preference;
    }

    /**
     * <p>Acesta este algoritmul lui BellmanFord,care imi calculeaza cel mai mic drum de la o locatie la alta</p>
     *
     * @param primaLocatie locatia de unde plec,primul nod al drumului
     * @param aDouaLocatie locatia unde vreau sa ajung
     */
    public void orderAlgoritm(Location primaLocatie, Location aDouaLocatie) {
        int index1 = 0, k;
        int distance[] = new int[preference.size()];//vector care tine minte distanta fata de fiecare nod vizitat pentru fiecare pozitie
        int previous[] = new int[preference.size()];//in vectorul asta se pun nodurile prin care s-au trecut
        int indice1 = 0, indice2 = 0;
        int tempDistance = 0;//costul total
        for (int i = 0; i < preference.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
            if (preference.get(i).getName().equals(aDouaLocatie.name)) index1 = i;
        }
        distance[index1] = 0;
        for (int i = 0; i < oras.getLocatii().size(); i++) {//iau toate locatiile din orasul obiectului
            for (int j = 1; j < oras.getLocatii().get(i).getCost().size(); j++) {//iau fiecare locatie in parte cate interactiuni are cu celelalte locatii
                Location preference1 = oras.getLocatii().get(i);
                Location preference2 = oras.getLocatii().get(j);
                if (!preference1.equals(preference2)) {//verific ca nu am muchie intre o lactie si ea insasi
                    // voi folosi exceptii pentru ca programul sa stie si sa imi afiseze direct eroare cand nu exista muchie intre 2 locatii
                    try {
                        int cost = preference1.verifyExistingCost(preference2);// mi se ia costul dintre cele 2 muchii daca exista
                        if (distance[i] != Integer.MAX_VALUE && distance[i] + cost < distance[j])
                            //distance[j]=distance[i]+cost;
                            tempDistance = distance[j] + cost;//calculez distanta(costul) si il adaug la costul final
                        if (tempDistance < distance[i]) {//daca este mai mic modific distanta pe care o vom afisa si notam in previous de i ca am trecut prin j
                            distance[i] = tempDistance;
                            previous[i] = j;
                        } else if (tempDistance == distance[i]) {//daca sunt egale le luam in functie de ordine
                            for (k = 0; k < preference.size(); k++)
                                if (oras.locatii.get(previous[i]) == preference.get(k)) {
                                    indice1 = k;
                                }
                            if (oras.locatii.get(j) == preference.get(k)) indice2 = k;
                            if (indice1 < indice2) {
                                distance[i] = tempDistance;
                                previous[i] = indice1;
                            } else {
                                distance[i] = tempDistance;
                                previous[i] = indice2;
                            }
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }
        System.out.println("Distanta de la " + primaLocatie.getName() + " -> " + aDouaLocatie.getName() + " : " + tempDistance);
    }
}
