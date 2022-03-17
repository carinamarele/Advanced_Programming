/**
 * <p>Clasa pentru tabela de genuri care ma va ajuta sa afisez date despre informatiile din tabelul respectiv</p>
 */
public class Genres {
    int id_genre;
    String name;

    public Genres(int id_genre, String name) {
        this.id_genre = id_genre;
        this.name = name;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genul cu id-ul " +
                 id_genre +
                " este " + name;
    }
}
