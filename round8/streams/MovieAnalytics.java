
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;



public class MovieAnalytics {
    
    ArrayList<Movie> list;

    public MovieAnalytics() {
        list = new ArrayList<>();
    }
    
    static Consumer<Movie> showInfo() {
        
        Consumer<Movie> print = (Movie x) -> System.out.println(x.getTitle()
        + " (By " + x.getDiretor() + ", " + x.getReleaseYear() + ")");
        
        return print;
    }
    
    void populateWithData(String fileName) throws FileNotFoundException, IOException {
        // File path is passed as parameter
        File file = new File(fileName);
 
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader br;
        
        br = new BufferedReader(new FileReader(file));
        
 
        // Declaring a string variable
        String st;
        
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null) {
                String[] p = st.split(";");
                
                Movie newMov = new Movie(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]), p[3], Double.parseDouble(p[4]), p[5]);
                list.add(newMov);
            }
            
            Collections.sort(list);

    }
    
    Stream<Movie> moviesAfter(int year) {
        Stream<Movie> moviesAfter = Stream.empty();
        for (Movie m : list) {
            if (m.getReleaseYear() >= year) {
                moviesAfter = Stream.concat(moviesAfter, Stream.of(m));
            }
        }
        
        return moviesAfter;
    }
    
    Stream<Movie> moviesBefore(int year) {
        Stream<Movie> movies = Stream.empty();
        for (Movie m : list) {
            if (m.getReleaseYear() <= year) {
                movies = Stream.concat(movies, Stream.of(m));
            }
        }
        
        return movies;
    }
    
    Stream<Movie> moviesBetween(int yearA, int yearB) {
        Stream<Movie> movies = Stream.empty();
        for (Movie m : list) {
            if (m.getReleaseYear() >= yearA && m.getReleaseYear() <= yearB) {
                movies = Stream.concat(movies, Stream.of(m));
            }
        }
        
        return movies;
    }
    
    Stream<Movie> moviesByDirector(String director) {
        Stream<Movie> movies = Stream.empty();
        for (Movie m : list) {
            if (m.getDiretor().equals(director)) {
                movies = Stream.concat(movies, Stream.of(m));
            }
        }
        return movies;
    }
    
}
