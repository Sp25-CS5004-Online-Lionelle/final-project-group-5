package student.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * MovieList class that implements IMovieList.
 * Stores unique, case-insensitively sorted Movie objects.
 */
public class MovieList implements IMovieList {

    // Uses TreeSet with custom comparator to avoid duplicates and keep sort order
    private final Set<Movie> movies;

    /**
     * Constructor initializes the movie set with case-insensitive title sorting.
     */
    public MovieList() {
        this.movies = new TreeSet<>(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER));
    }

    /**
     * Returns the list of movie titles in ascending order (case-insensitive).
     * @param movies List of Movie objects
     * @return List of movie titles
     */
    @Override
    public List<String> getMovieTitles() {
        return movies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of all Movie objects in ascending order by title.
     * @return List of Movie objects
     */
    @Override
    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    /**
     * Adds a single movie to the list if it doesn't already exist.
     * @param movie Movie object to add
     */
    @Override
    public void add(Movie movie) {
        if (movie != null) {
            movies.add(movie);
        }
    }

    /**
     * Adds multiple movies to the list.
     * @param movieList List of Movie objects to add
     */
    @Override
    public void addAll(List<Movie> movieList) {
        if (movieList != null) {
            for (Movie movie : movieList) {
                add(movie);
            }
        }
    }

    /**
     * Removes a single movie from the list.
     * @param movie Movie object to remove
     */
    @Override
    public void remove(Movie movie) {
        movies.remove(movie);
    }

    /**
     * Removes multiple movies from the list.
     * @param movieList List of Movie objects to remove
     */
    @Override
    public void removeAll(List<Movie> movieList) {
        if (movieList != null) {
            movies.removeAll(movieList);
        }
    }

    /**
     * Clears the movie list.
     */
    @Override
    public void clear() {
        movies.clear();
    }

    /**
     * Returns the size of the movie list.
     * @return Number of movies in the list
     */
    @Override
    public int size() {
        return movies.size();
    }

    @Override
    public void save(String fileType) throws Exception {
    if (!fileType.equalsIgnoreCase("json")) {
        throw new UnsupportedOperationException("Only JSON format is supported.");
    }
    IStorage.writeToUserMovieList(new ArrayList<>(movies)); // default user file
}

}
