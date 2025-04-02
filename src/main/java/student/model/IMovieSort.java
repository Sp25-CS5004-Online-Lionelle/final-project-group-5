package student.model;

import java.util.List;
import java.util.stream.Stream;

public interface IMovieSort {

    /**
     * We are
     * @param filteredMovieList
     * @param filterType
     * @return A stream of sorted movie
     */
Stream<Movie> sort(List<Movie> filteredMovieList, FilterType filterType);



/**
 *
 * @param filteredMovieList
 * @param filterType
 * @param ascending
 * @return
 */
Stream<Movie> sort( List<Movie> filteredMovieList, FilterType filterType, boolean ascending);
}
