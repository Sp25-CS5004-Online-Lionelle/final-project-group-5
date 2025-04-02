package student.model;

import java.util.List;
import java.util.stream.Stream;

public interface IMovieFilter {
/**
 *
 * @param operation the filter to apply to the movie collections.
 * @return A stream of movies that match the filter
 */
Stream<Movie> filter(List<Movie> movieList, FilterType filterType, String value);

/**
 * clear the filteredMovieList
 */

void reset();
}
