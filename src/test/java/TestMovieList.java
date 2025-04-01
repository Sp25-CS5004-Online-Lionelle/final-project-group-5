
import student.model.Movie;
import student.model.MovieList;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestMovieList {

    @Test
    public void testAddAndRetrieveMovies() {
        MovieList list = new MovieList();
        Movie m1 = new Movie("Inception", 8.8, 2010, "Sci-Fi", List.of(), "", "");
        Movie m2 = new Movie("The Matrix", 8.7, 1999, "Sci-Fi", List.of(), "", "");

        list.add(m1);
        list.add(m2);

        List<String> titles = list.getMovieTitles();
        assertEquals(2, titles.size());
        assertTrue(titles.contains("Inception"));
        assertTrue(titles.contains("The Matrix"));
    }

    @Test
    public void testNoDuplicates() {
        MovieList list = new MovieList();
        Movie m1 = new Movie("Inception", 8.8, 2010, "Sci-Fi", List.of(), "", "");
        Movie m2 = new Movie("Inception", 9.0, 2010, "Action", List.of(), "", "");

        list.add(m1);
        list.add(m2);

        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveMovie() {
        MovieList list = new MovieList();
        Movie m1 = new Movie("Inception", 8.8, 2010, "Sci-Fi", List.of(), "", "");

        list.add(m1);
        list.remove(m1);

        assertEquals(0, list.size());
    }
}
