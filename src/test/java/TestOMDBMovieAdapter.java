import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import student.model.Movie;
import student.model.OMDBMovieAdapter;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestOMDBMovieAdapter {

    @Test
    public void testAdapterLoadsMoviesFromExampleJson() throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream("OMDb_SmallExample.json");
        assertNotNull(in, "OMDb_SmallExample.json not found in resources");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(in);

        assertTrue(root.isArray(), "Root should be a JSON array");

        List<Movie> movies = new ArrayList<>();
        for (JsonNode node : root) {
            Movie movie = OMDBMovieAdapter.convert(node);
            assertNotNull(movie);
            movies.add(movie);
        }

        assertEquals(2, movies.size(), "Expected 2 movies from file");

        Movie ratatouille = movies.get(0);
        assertEquals("Ratatouille", ratatouille.getTitle());
        assertEquals(2007, ratatouille.getYear());
        assertEquals(8.1, ratatouille.getAverageRating(), 0.01);
        assertTrue(ratatouille.getGenre().contains("Animation"));
        assertTrue(ratatouille.getDescription().toLowerCase().contains("rat who can cook"));
        assertTrue(ratatouille.getImageUrl().startsWith("https://"));
        assertTrue(ratatouille.getCast().contains("Patton Oswalt"));

        Movie springBreakers = movies.get(1);
        assertEquals("Spring Breakers", springBreakers.getTitle());
        assertEquals(2012, springBreakers.getYear());
        assertEquals(5.3, springBreakers.getAverageRating(), 0.01);
        assertTrue(springBreakers.getGenre().contains("Drama"));
        assertTrue(springBreakers.getDescription().toLowerCase().contains("college girls"));
        assertTrue(springBreakers.getImageUrl().startsWith("https://"));
        assertTrue(springBreakers.getCast().contains("Selena Gomez"));
    }
}
