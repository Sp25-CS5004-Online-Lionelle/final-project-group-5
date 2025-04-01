import student.model.Movie;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestMovie {

    @Test
    public void testMovieEquality() {
        Movie m1 = new Movie("Inception", 8.8, 2010, "Sci-Fi",
                List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt"), 
                "A thief steals corporate secrets through dream-sharing tech.",
                "https://image.url");

        Movie m2 = new Movie("Inception", 8.8, 2010, "Sci-Fi",
                List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt"), 
                "A thief steals corporate secrets through dream-sharing tech.",
                "https://image.url");

        assertEquals(m1, m2);
        assertEquals(m1.hashCode(), m2.hashCode());
    }

    @Test
    public void testMovieToString() {
        Movie movie = new Movie("Interstellar", 8.6, 2014, "Sci-Fi",
                List.of("Matthew McConaughey", "Anne Hathaway"), 
                "A team travels through a wormhole in search of a new home.",
                "https://image.url");

        assertEquals("Interstellar (2014)", movie.toString());
    }
}
