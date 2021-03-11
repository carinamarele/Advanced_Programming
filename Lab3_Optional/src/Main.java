import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Main {
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m";

    /**
     * <p>Declar obiectele de tipul Museum,Hotel,Church,Restaurant</p>
     * <p>Adaug la fiecare ora deschiderii,ora inchiderii,costurile,nume</p>
     *
     * @param args parametri cititi de la linia de comanda,nu sunt folositi
     */
    public static void main(String[] args) {


        Museum m = new Museum(); //v2
        m.setOpeningTime(LocalTime.of(9, 30));
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        m.setAdresa("Stefan cel Mare");
        m.setName("A");


        Museum m1 = new Museum(LocalTime.of(9, 30), LocalTime.parse("20:00"), 30, "Dragos Voda"); //v3
        m1.setName("B");


        Church c = new Church(); //v4
        c.setOpeningTime(LocalTime.of(7, 0));
        c.setClosingTime(LocalTime.MIDNIGHT);
        c.setName("A");
        c.setReligie("Ortodoxa");
        c.setAdresa("Crizantemelor");


        Church c1 = new Church(); //v5
        c1.setOpeningTime(LocalTime.of(05, 0));
        c1.setClosingTime(LocalTime.of(23, 30, 00));
        c1.setName("B");
        c1.setReligie("Romano-Catolica");
        c1.setAdresa("Pestisorul");


        Hotel h = new Hotel(); //v1
        h.setOpeningTime(LocalTime.of(6, 30));
        h.setClosingTime(LocalTime.MIDNIGHT);
        h.setTicketPrice(300);
        h.setName("Unirea");
        h.setAdresa("Independentei");


        Restaurant r = new Restaurant(); //v6
        r.setOpeningTime(LocalTime.of(8, 30));
        r.setClosingTime(LocalTime.MIDNIGHT);
        r.setName("Trattoria");
        r.setAdresa("Crinilor");


        Restaurant r1 = new Restaurant(LocalTime.of(7, 0), LocalTime.MIDNIGHT, 20, "Stefan cel mare", 2); //v7

        r1.setName("Alt Restaurant");

        Visitable[] arr = {h, m, m1, c, c1, r};

        h.setCost(m, 10);
        h.setCost(m1, 50);
        m.setCost(m1, 20);
        m.setCost(c, 20);
        m.setCost(c, 10);
        m1.setCost(c, 20);
        c.setCost(c1, 30);
        c.setCost(r, 10);
        c1.setCost(r, 20);

        System.out.println(h);

        //Afisez matricea de costuri pentru fiecare obiect

        for (Location id : h.cost.keySet()) {
            System.out.println(h.name + "->" + id.name + " | " + h.cost.get(id));
        }
        System.out.println(m);

        for (Location id : m.cost.keySet()) {
            System.out.println(m.name + "->" + id.name + " | " + m.cost.get(id));
        }
        System.out.println(m1);

        for (Location id : m1.cost.keySet()) {
            System.out.println(m1.name + "->" + id.name + " | " + m1.cost.get(id));
        }
        System.out.println(c);

        for (Location id : c.cost.keySet()) {
            System.out.println(c.name + "->" + id.name + " | " + c.cost.get(id));
        }
        System.out.println(c1);

        for (Location id : c1.cost.keySet()) {
            System.out.println(c1.name + "->" + id.name + " | " + c1.cost.get(id));
        }
        System.out.println(r);

        for (Location id : r.cost.keySet()) {
            System.out.println(r.name + "->" + id.name + " | " + r.cost.get(id));
        }
        System.out.println(r1);

        for (Location id : r1.cost.keySet()) {
            System.out.println(r1.name + "->" + id.name + " | " + r1.cost.get(id));
        }

        //optional
        /*subpunctul 1 */
        System.out.println("\n" + COLOR_PURPLE + "Subpunctul 1:\n" + RESET);
        City Iasi = new City("Iasi");

        Iasi.locatii.add(m);
        Iasi.locatii.add(r1);
        Iasi.locatii.add(c);
        Iasi.locatii.add(c1);
        Iasi.locatii.add(m1);

        System.out.println("Locatii vizitabile si nu platibile in functie de ora de deschidere:\n");
        Iasi.VisitHour();

        /*subpunctul 2*/
        System.out.println("\n" + COLOR_PURPLE + "Subpunctul 2:\n" + RESET);
        Church bisericaCentru = new Church();
        bisericaCentru.setName("Sf. Anton");
        bisericaCentru.setAdresa("Grigore Ureche");
        bisericaCentru.setReligie("Protestanta");
        bisericaCentru.setCapacitate(100);
        bisericaCentru.setDefaultClosingTime();
        bisericaCentru.setDefaultOpeningTime();

        System.out.println(bisericaCentru);

        /*subpunctul 3*/
        LocalTime open, close;
        open = bisericaCentru.getOpeningTime();
        close = bisericaCentru.getClosingTime();
        System.out.println(COLOR_PURPLE + "Subpunctul 3: \nBiserica " + RESET + bisericaCentru.name + " " + Visitable.getVisitingDuration(open, close));

        open = c1.getOpeningTime();
        close = c1.getClosingTime();
        System.out.println(COLOR_PURPLE + "Biserica " + RESET + c1.name + " " + Visitable.getVisitingDuration(open, close));

        /* subpunctul 4*/
        System.out.println("\n" + COLOR_PURPLE + "Subpunctul 4: \n" + RESET);
        TravelPlan calator = new TravelPlan();
        calator.setOras(Iasi);
        List<Location> preferinte = new ArrayList<>();
        preferinte.add(m);
        preferinte.add(m1);
        calator.setPreference(preferinte);
        System.out.println("Orasul: " + calator.getOras() + "\nPreferintele sunt: \n" + calator.getPreference());

        /*subpunctul 5*/
        calator.orderAlgoritm(m,r1);
    }
}
