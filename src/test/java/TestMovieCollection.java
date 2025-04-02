import student.model.MovieCollection;
import student.model.Movie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.google.common.annotations.VisibleForTesting;

public class TestMovieCollection {

    static Set<Movie>  movies = new HashSet<>();
    static List<Movie> filteredMovieList;

    @BeforeAll
    public static void setup(){
        movies.add(new Movie("Minions", 6.4, 2015, "Comedy",  List.of(), "", ""));
        movies.add(new Movie("Test Movie 1", 5.2, 2018, "Adventure", List.of(), "", ""));
        movies.add(new Movie("Another Movie", 7.2, 2018, "Adventure", List.of(), "", ""));

    }

    @Test
    public void testFilterByTitle(){
        filteredMovieList = movies.filterByTitle("Minions");

        assertEquals("Minions", movies.get(0).getTitle());
    }

}
