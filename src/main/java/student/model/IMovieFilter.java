package student.model;

import java.util.List;
import java.util.stream.Stream;

public interface IMovieFilter {
    /**
     *
     * @param movieList the list of movies to be filtered
     * @param op operations, such as CONTAINS, EQUALS, etc
     * @param filterType, filterType, such as TITLE, YEAR, etc
     * @param value, THE value to filter based on
     * @return a stream of movie
     */
    Stream<Movie> filter(List<Movie> movieList, Operations op, FilterType filterType, String value);

/**
 * clear the filteredMovieList
 */

//void reset();
}
