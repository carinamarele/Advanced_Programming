import java.time.LocalTime;

public class Main {
    /**
     * <p>Declar obiectele de tipul Museum,Hotel,Church,Restaurant</p>
     * <p>Adaug la fiecare ora deschiderii,ora inchiderii,costurile,nume</p>
     * @param args parametri cititi de la linia de comanda,nu sunt folositi
     */
    public static void main(String[] args){

        Museum m=new Museum();
        m.setOpeningTime(LocalTime.of(9,30));
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        m.setName("A");

        m.cost.put("v2->v3",20);
        m.cost.put("v2->v4",20);

        System.out.println(m);
        System.out.println("From to + cost for m(v2) "+m.cost);
        System.out.println("");


        Museum m1=new Museum();
        m1.setOpeningTime(LocalTime.of(10,0));
        m1.setClosingTime(LocalTime.parse("20:00"));
        m1.setTicketPrice(50);
        m1.setName("B");
        m1.cost.put("v3->v4",20);
        System.out.println(m1);
        System.out.println("From to + cost for m1(v3) "+m1.cost);
        System.out.println("");


        Church c=new Church();
        c.setOpeningTime(LocalTime.of(7,0));
        c.setClosingTime(LocalTime.MIDNIGHT);
        c.setName("A");
        c.cost.put("v4->v5",30);
        c.cost.put("v4->v6",10);
        System.out.println(c);
        System.out.println(" From to + cost for c(v4) "+c.cost);
        System.out.println("");


        Church c1=new Church();
        c1.setOpeningTime(LocalTime.of(5,0));
        c1.setClosingTime(LocalTime.MIDNIGHT);
        c1.setName("B");
        c1.cost.put("v5->v6",20);
        System.out.println(c1);
        System.out.println("From to + cost for c1(v5) "+c1.cost);
        System.out.println("");


        Hotel h=new Hotel();
        h.setOpeningTime(LocalTime.of(6,30));
        h.setClosingTime(LocalTime.MIDNIGHT);
        h.setTicketPrice(300);
        h.cost.put("v1->v2",10);
        h.cost.put("v1->v3",50);
        System.out.println(h);
        System.out.println(" From to + cost for h(v1) "+h.cost);
        System.out.println("");


        Restaurant r =new Restaurant();
        r.setOpeningTime(LocalTime.of(8,30));
        r.setClosingTime(LocalTime.MIDNIGHT);
        System.out.println(r);
        System.out.println(" From to + cost for r(v6) "+r.cost);
        System.out.println("");

        Visitable[] arr={h,m,m1,c,c1,r};
    }
}
