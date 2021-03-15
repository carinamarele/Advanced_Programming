import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    /**
     * <p>Dupa ce creez listele de elevi si licee voi seta capacitatile liceelor si voi crea 2 liste pentru preferintele liceelor si a elevilor</p>
     * <p>Voi crea dupa si cele 2 mape in care voi memora apoi preferintele</p>
     * <p>Ma voi folosi de cele 2 liste create(preferinteS si preferinteH) pentru a adauga in mapuri datele cerute</p>
     * <p>Prima data adaug in liste si dupa adaug in mapuri si dupa voi sterge elementele listelor pentru a putea completa si pentru celelalte obiecte de tipul Student si School create</p>
     * @param args nu se foloseste linia de comanda deci nu vom avea ce prelua din ea,nu se va folosi args
     */
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);

        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i, 6 * i + 2)).toArray(School[]::new);

        schools[0].setCapacitate(1);
        schools[1].setCapacitate(2);
        schools[2].setCapacitate(2);

        List<School> preferinteS = new ArrayList<>();//vector de preferinte a elevilor cu licee
        List<Student> preferinteH = new ArrayList<>();//vector de preferinte ale liceelor cu elevi


        Map<Student, List<School>> stdPrefMapStudents = new HashMap<>();
        Map<School, List<Student>> stdPrefMapSchools = new HashMap<>();

        /* Liceu 0 (H0): */
        preferinteH.add(students[3]);
        preferinteH.add(students[0]);
        preferinteH.add(students[1]);
        preferinteH.add(students[2]);

        /*
        In preferinteH am pus preferintele liceelor pe care le voi adauga in map ul de scoli
        Dupa voi sterge tot ce am in vectorul cu elevi pentru a putea realiza lista de prefrinte pentru urmatorul liceu
         */

        schools[0].setPreferinte(preferinteH);
        stdPrefMapSchools.put(schools[0], preferinteH);
        preferinteH.clear();

        /* Liceu 1 (H1): */
        preferinteH.add(students[0]);
        preferinteH.add(students[2]);
        preferinteH.add(students[1]);

        schools[1].setPreferinte(preferinteH);
        stdPrefMapSchools.put(schools[1], preferinteH);
        preferinteH.clear();

        /* Liceu 2 (H2): */
        preferinteH.add(students[0]);
        preferinteH.add(students[1]);
        preferinteH.add(students[3]);

        schools[2].setPreferinte(preferinteH);
        stdPrefMapSchools.put(schools[2], preferinteH);
        preferinteH.clear();

        /* Elev 0 (S0): */
        preferinteS.add(schools[0]);
        preferinteS.add(schools[1]);
        preferinteS.add(schools[2]);

        /*
        cum am facut la licee,procedam la fel si pentru studenti
        in preferinteS am pus preferintele elevilor pe care le voi adauga in map ul de elevi
        */
        students[0].setPreferinte(preferinteS);
        stdPrefMapStudents.put(students[0], preferinteS);
        preferinteS.clear();

        /* Elev 1 (S1): */
        preferinteS.add(schools[0]);
        preferinteS.add(schools[1]);
        preferinteS.add(schools[2]);

        students[1].setPreferinte(preferinteS);
        stdPrefMapStudents.put(students[1], preferinteS);
        preferinteS.clear();

        /* Elev 2 (S2): */
        preferinteS.add(schools[0]);
        preferinteS.add(schools[1]);

        students[2].setPreferinte(preferinteS);
        stdPrefMapStudents.put(students[2], preferinteS);
        preferinteS.clear();

        /* Elev 3 (S3): */
        preferinteS.add(schools[0]);
        preferinteS.add(schools[2]);

        students[3].setPreferinte(preferinteS);
        stdPrefMapStudents.put(students[3], preferinteS);
        preferinteS.clear();

        //Afisez informatiile despre elevi si licee,adica numele,capacitate(scoala) si preferintele lor
        for (int i = 0; i < students.length; i++)
            System.out.println(students[i]);
        for (int i = 0; i < schools.length; i++)
            System.out.println(schools[i]);

        //Subpunct c) compulsory
        /* adaug studentii in lista in afara de studentul 1 pe care il voi pune la final pentru a fi sigur ca se ordoneaza  */
        LinkedList<Student> studentList = new LinkedList<>();

        for (int i = 0; i < students.length; i++) {
            if(i!=1) studentList.add(students[i]);
        }
        studentList.add(students[1]);

        System.out.println("Lista de studenti sortata: ");
        List<Student> newSortedList = studentList.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        System.out.println(newSortedList);
        studentList.stream().filter(std -> stdPrefMapStudents.get(std).contains(schools[0].getPreferinte())).forEach(System.out::println);
        System.out.println(stdPrefMapStudents);

        TreeSet<String> schoolSet = new TreeSet<String>();


        //for(int i=0;i<schools.length;i++)
        schoolSet.add(schools[0].getName());
        schoolSet.add(schools[1].getName());
        schoolSet.add(schools[2].getName());
        System.out.println("TreeSetul de scoli este: "+ schoolSet);

        List<School> target = Arrays.asList(schools[0], schools[2]);


        // List<Student> result = studentList.stream().filter(std -> stdPrefMapSchools.get(std).containsAll(target)).collect(Collectors.toList());


    }
}
