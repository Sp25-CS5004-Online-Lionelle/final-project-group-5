package student.model;
import java.util.List;

/**
 * Interface for a list of movies.
 * Used to manage a user-curated list of Movie objects.
 */
public interface IMovieList {

    /**
     * Returns all movie titles in ascending order (case-insensitive).
     */
    List<String> getMovieTitles();

    /**
     * Returns the list of Movie objects in ascending order by title (case-insensitive).
     */
    List<Movie> getMovies();

    /**
     * Adds a movie to the list. No duplicates allowed.
     */
    void add(Movie movie);

    /**
     * Adds a list of movies.
     */
    void addAll(List<Movie> movies);

    /**
     * Removes a movie from the list.
     */
    void remove(Movie movie);

    /**
     * Removes a list of movies.
     */
    void removeAll(List<Movie> movies);

    /**
     * Clears the entire list.
     */
    void clear();

    /**
     * Returns the number of movies in the list.
     */
    int size();

     /**
     * Saves the movie list to a file.
     *
     * @param fileType the format
     * @throws Exception if the save fails
     */
    void save(String fileType) throws Exception;
}
