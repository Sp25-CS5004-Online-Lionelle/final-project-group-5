import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.ObjectMapper;
import student.model.FilterType;
import student.model.MovieCollection;
import student.model.Movie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import student.model.OMDBMovieData;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMovieCollection {

    static MovieCollection movieCollection;
    @BeforeAll
    public static void setup(){
        movieCollection = new MovieCollection("movieList.json");
    }

    @Test
    public void testConstructor(){
        assertEquals(3, movieCollection.getMovies().size());
    }


    @Test
    public void testGetFilteredMovies() {
        assertEquals(2, movieCollection.getFilteredMovies("M").size());
    }

    @Test
    public void testGetFilteredMovieswithFetch() {

        movieCollection.getFilteredMovies("Dog Man");
        assertEquals(4, movieCollection.getMovies().size());
    }
    @Test
    public void testSortFilteredMoviesYear() {
        movieCollection.getFilteredMovies("M");
        List<Movie> sortedMovieList = movieCollection.sortFilteredMovies(FilterType.YEAR, true);
        List<Movie> sortedMovieList1 = movieCollection.sortFilteredMovies(FilterType.YEAR, false);

        Movie firstMovie = sortedMovieList.get(1);
        assertEquals("Minions", firstMovie.getTitle());
        Movie secondMovie = sortedMovieList1.get(1);
        assertEquals("Moon", secondMovie.getTitle());
    }

    @Test
    public void testSortFilteredMoviesRating() {
        movieCollection.getFilteredMovies("M");
        List<Movie> sortedMovieList = movieCollection.sortFilteredMovies(FilterType.RATING, true);
        List<Movie> sortedMovieList1 = movieCollection.sortFilteredMovies(FilterType.RATING, false);

        Movie firstMovie = sortedMovieList.get(1);
        assertEquals("Moon", firstMovie.getTitle());
        Movie secondMovie = sortedMovieList1.get(1);
        assertEquals("Minions", secondMovie.getTitle());
    }

}
