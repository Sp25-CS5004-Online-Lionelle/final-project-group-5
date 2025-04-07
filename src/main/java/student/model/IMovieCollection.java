package student.model;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Stream;

public interface IMovieCollection {
  /** Do not change the file address! */
    String DATABASE = "src/main/resources/movieList.json";

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
     * Writes out the records to the outputstream.
     *
     * OutputStream could be System.out or a FileOutputStream.
     *
     * @param records the records to write, could be a single entry.
     * @param format the format to write the records in
     * @param out the output stream to write to
     */
    // static void writeRecords(List<Movie> records, FilterType filterType, OutputStream out) {
    //     InputWritter.write(records, filterType, out);
    // }


    /**
     * Gets an instance of the model using the 'default' location.
     *
     * @return the instance of the model
     */
    static IMovieCollection getInstance() {
        return getInstance(DATABASE);
    }

    /**
     * Gets an instance of the model using the 'default' class.
     * Good spot to get the InputStream from the DATABASE file, and use that stream to build the
     * model.
     *
     * @param database the name of the file to use
     * @return the instance of the model
     */
    static IMovieCollection getInstance(String database) {
        return new MovieCollection(database);
    }

  void reset();

}

