/**
 * <p>Clasa Movie ajuta la afisarea informatiilor despre tabelul movie si ce contine el</p>
 */
public class Movie {
    int id_movie;
    String title;
    String release_date;
    int duration;
    double score;

    public Movie(int id_movie, String title,String release_date,int duration,double score){
        this.id_movie=id_movie;
        this.title=title;
        this.release_date=release_date;
        this.duration=duration;
        this.score=score;
    }

    public int getId_movie() {
        return id_movie;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Filmul " + title+" cu id-ul "+id_movie +
                " scos pe data de " + release_date  +
                " cu durata de " + duration +
                " minute si scorul " + score +
                " stele.";
    }

    public void setScore(double score) {
        this.score = score;
    }
}
