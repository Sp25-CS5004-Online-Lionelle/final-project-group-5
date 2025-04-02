package student.model;
import java.util.stream.Stream;

public interface IMovieCollection {

/**
 *
 * @param operation the filter to apply to the movie collections.
 * @return A stream of movies that match the filter
 */
Stream<Movie> filter(Operations operation, String value);


/**
 *
 * @param operation The sort condition to apply to the movie collections.
 * @return A stream of movies that sorted
 */
Stream<Movie> sort(Operations operations);



/**
 *
 * @param operation The sort condition to apply to the movie collections.
 * @param ascending Whether to sort the results in ascending order or descending order.
 * @return  A stream of movies that sorted
 */
Stream<Movie> sort(Operations operation, boolean ascending);

/**
* Resets the collection to have no filters applied.
*/
void reset();

}

