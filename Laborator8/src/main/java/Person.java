//Clasa Person pentru tabelul person si pentru a afla informatii despre actori si directori
public class Person {
    int id_person;
    String firstName;
    String lastName;
    String gender;
    int age;

    public Person(int id_person, String firstName, String lastName, String gender, int age) {
        this.id_person = id_person;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "Nume & Prenume " + firstName + " "+lastName +
                " in varsta de " + age;
    }
}
