import student.model.MovieStorage;
import student.model.Movie;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestMovieStorage {


    @Test
    public void testFilePathWorks() {
        String path = "src/test/JsonTestFiles/2_movies.json";

        File file = new File(path);
        assertTrue(file.exists());
    }

    @Test
    public void testReadJsonReturns() {
        String path = "src/test/JsonTestFiles/2_movies.json";
        String path2 ="src/test/JsonTestFiles/database.json";

        try {
            FileInputStream fis = new FileInputStream(path);
            List<Movie> movies = MovieStorage.readJSON(new FileInputStream(path));
            for (Movie movie : movies) {
                System.out.println(movie);
            }
            assertNotNull(movies);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadJson() {
        String path = "src/test/JsonTestFiles/2_movies.json";

        List<String> movie1Cast = Arrays.asList("Brad Garrett", "Lou Romano", "Patton Oswalt");
        List<String> movie1Genre = Arrays.asList("Animation", "Adventure", "Comedy");
        Movie movie1 = new Movie("Ratatouille", 8.1, 2007, movie1Genre,
                movie1Cast, "A rat who can cook makes an unusual alliance with a young kitchen worker at a famous Paris restaurant.",
                "https://m.media-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg");

        List<String> movie2Cast = Arrays.asList("Vanessa Hudgens", "Selena Gomez", "Ashley Benson");
        List<String> movie2Genre = Arrays.asList("Crime", "Drama", "Thriller");
        Movie movie2 = new Movie("Spring Breakers", 5.3, 2012, movie2Genre,
                movie2Cast, "Four college girls hold up a restaurant in order to fund their spring break vacation. While partying, drinking, and taking drugs, they are arrested, only to be bailed out by a drug and arms dealer.",
                "https://m.media-amazon.com/images/M/MV5BNTk3NjMwMjYtODg3Ny00ZDU2LTgzZDAtNDJjYjlmYjJjNGQ3XkEyXkFqcGc@._V1_SX300.jpg");

        try {
            List<Movie> movies = new ArrayList<>();
            FileInputStream fis = new FileInputStream(path);
            movies.addAll(MovieStorage.readJSON(fis));
            assertEquals(movie1, movies.get(0));
            assertEquals(movie2, movies.get(1));
            assertEquals(2, movies.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testReadAppDatabase(){
        String path = "src/test/JsonTestFiles/database.json";

        List<String> movie1Cast = Arrays.asList("Brad Garrett", "Lou Romano", "Patton Oswalt");
        List<String> movie1Genre = Arrays.asList("Animation", "Adventure", "Comedy");
        Movie movie1 = new Movie("Ratatouille", 8.1, 2007, movie1Genre,
                movie1Cast, "A rat who can cook makes an unusual alliance with a young kitchen worker at a famous Paris restaurant.",
                "https://m.media-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg");

        List<String> movie2Cast = Arrays.asList("Vanessa Hudgens", "Selena Gomez", "Ashley Benson");
        List<String> movie2Genre = Arrays.asList("Crime", "Drama", "Thriller");
        Movie movie2 = new Movie("Spring Breakers", 5.3, 2012, movie2Genre,
                movie2Cast, "Four college girls hold up a restaurant in order to fund their spring break vacation. While partying, drinking, and taking drugs, they are arrested, only to be bailed out by a drug and arms dealer.",
                "https://m.media-amazon.com/images/M/MV5BNTk3NjMwMjYtODg3Ny00ZDU2LTgzZDAtNDJjYjlmYjJjNGQ3XkEyXkFqcGc@._V1_SX300.jpg");

        try {
            List<Movie> movies = new ArrayList<>();
            FileInputStream fis = new FileInputStream(path);
            movies.addAll(MovieStorage.readJSON(fis));

            assertEquals(movie1, movies.get(0));
            assertEquals(movie2, movies.get(1));
            assertEquals(2, movies.size());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testWriteJson() {
        String toAppend = "src/test/JsonTestFiles/toAppend.json";
        String afterAppend = "src/test/JsonTestFiles/afterAppendMovieDatabase.json";
        String test = "src/test/JsonTestFiles/Tester.json";
        try {
            FileInputStream fis = new FileInputStream(toAppend);
            MovieStorage.appendNewMovieJsonToDatabase(fis);

            byte[] testDatabase = Files.readAllBytes(Path.of(test));
            byte[] afterAppendDatabase = Files.readAllBytes(Path.of(afterAppend));

            assertTrue(Arrays.equals(testDatabase, afterAppendDatabase));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}