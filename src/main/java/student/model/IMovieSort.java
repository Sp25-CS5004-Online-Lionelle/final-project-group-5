package student.model;

import java.util.List;
import java.util.stream.Stream;

public interface IMovieSort {

    /**
     * We are
     * @param filteredMovieList, a list of filtered movie
     * @param filterType, filter type
     * @return A list of sorted movie
     */
List<Movie> sort(List<Movie> filteredMovieList, FilterType filterType);

/**
 *
 * @param filteredMovieList a list of filtered movie
 * @param filterType
 * @param ascending, if ascending is true, sort the filtered movie in ascending order, otherwise, sort it in the descending order
 * @return return movies in a sorted order
 */
List<Movie> sort( List<Movie> filteredMovieList, FilterType filterType, boolean ascending);
}
