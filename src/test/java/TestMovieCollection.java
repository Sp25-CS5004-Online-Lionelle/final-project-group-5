import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.ObjectMapper;
import student.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMovieCollection {

    static MovieCollection movieCollection;
    @BeforeAll
    public static void setup(){
        movieCollection = new MovieCollection();
    }

    @Test
    public void testConstructor(){
        assertEquals(6, movieCollection.getMovies().size());
    }


    @Test
    public void testGetFilteredMovies() {
        assertEquals(2, movieCollection.getFilteredMovies("M",Operations.CONTAINS, FilterType.TITLE).size());
    }

    @Test
    public void testGetFilteredMovieswithFetch() {

        movieCollection.getFilteredMovies("Dog Man", Operations.CONTAINS, FilterType.TITLE);
        assertEquals(5, movieCollection.getMovies().size());
        movieCollection.getFilteredMovies("Super Mario", Operations.CONTAINS, FilterType.TITLE);
        assertEquals(6, movieCollection.getMovies().size());

    }

    @Test
    public void testGetFilteredMoviesYearGreater() {
        assertEquals(2, movieCollection.getFilteredMovies("2009", Operations.GREATER_THAN_EQUAL, FilterType.YEAR).size());
    }


    @Test
    public void testGetFilteredMoviesYeaEqualS() {
        assertEquals(1, movieCollection.getFilteredMovies("2009", Operations.EQUALS, FilterType.YEAR).size());
    }

    @Test
    public void testGetFilteredMoviesGenre() {
        assertEquals("Moon", movieCollection.getFilteredMovies("Drama", Operations.CONTAINS, FilterType.GENRE).get(0).getTitle());
    }

    @Test
    public void testGetFilteredMoviesDesc() {
        assertEquals("Minions", movieCollection.getFilteredMovies("inventor", Operations.CONTAINS, FilterType.DESCRIPTION).get(0).getTitle());
    }

    @Test
    public void testSortFilteredMoviesYear() {
        movieCollection.getFilteredMovies("M", Operations.CONTAINS, FilterType.TITLE);
        List<Movie> sortedMovieList = movieCollection.sortFilteredMovies(FilterType.YEAR, true);
        List<Movie> sortedMovieList1 = movieCollection.sortFilteredMovies(FilterType.YEAR, false);

        Movie firstMovie = sortedMovieList.get(1);
        assertEquals("Minions", firstMovie.getTitle());
        Movie secondMovie = sortedMovieList1.get(1);
        assertEquals("Moon", secondMovie.getTitle());
    }

    @Test
    public void testSortFilteredMoviesRating() {
        movieCollection.getFilteredMovies("M", Operations.CONTAINS, FilterType.TITLE);
        List<Movie> sortedMovieList = movieCollection.sortFilteredMovies(FilterType.RATING, true);
        List<Movie> sortedMovieList1 = movieCollection.sortFilteredMovies(FilterType.RATING, false);

        Movie firstMovie = sortedMovieList.get(1);
        assertEquals("Moon", firstMovie.getTitle());
        Movie secondMovie = sortedMovieList1.get(1);
        assertEquals("Minions", secondMovie.getTitle());
    }

}
