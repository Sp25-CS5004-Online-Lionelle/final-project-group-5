package student.model;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Stream;

public interface IMovieCollection {
    /**
     * Get the whole list of movie that saved in the local json file.
     *
     * @return the list of movies
     */
    List<Movie> getMovies();


  /**
   * Get the list of movies that matches the filter conditions.
   *
   * @return the list of movies
   */
    List<Movie> getFilteredMovies(String value,  Operations op, FilterType filterType);
  /**
   *
   * @param sortType the type we need to the sort base on, such as RATING, TEAR
   * @param ascending, if we want to sort the movies ascending or descending
   * @return return the list of filtered movie in a sorted order
   */
    List<Movie> sortFilteredMovies(FilterType sortType, boolean ascending );


    /**
     * Gets an instance of the model using the 'default' class.
     * Good spot to get the InputStream from the DATABASE file, and use that stream to build the
     * model.
     *
     * @param database the name of the file to use
     * @return the instance of the model
     */
    static IMovieCollection getInstance() {
        return new MovieCollection();
    }

     void reset();

  }

