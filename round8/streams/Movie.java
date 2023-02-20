
public class Movie implements Comparable<Movie>{
    private String title;
    private int releaseYear;
    private int duration;
    private String genre;
    private double score;
    private String diretor;

    public Movie(String title, int releaseYear, int duration, String genre, double score, String diretor) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.genre = genre;
        this.score = score;
        this.diretor = diretor;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public double getScore() {
        return score;
    }

    public String getDiretor() {
        return diretor;
    }

    @Override
    public int compareTo(Movie o) {
        int i = this.releaseYear - o.getReleaseYear();
        if (i == 0) {return this.title.compareTo(o.getTitle());}
        return i;
    }
    
    
}
