package student.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieFilter implements IMovieFilter{


        /**
     * A list of filtered movies.
     */
    private List<Movie> filteredMovieList = new ArrayList<>();

    @Override
     public Stream<Movie> filter(List<Movie> movieList,  FilterType filterType, String value) {
        // TODO Auto-generated method stub
        switch (filterType) {
            case TITLE:
                return filterByTitle(movieList, value);
            case YEAR:
                return filterByYear(movieList, Integer.parseInt(value));
            default:
                return Stream.empty(); // will update this later, currently return an empty stream.
        }

     }

     /**
      *
      * @param title search movie by title, if can find the movie from local stored file,
      * then add the movie to the filtered movie list, if cannot find the move, then
      * add the movie to the saved local file in JSON format.
      * @return the filtered movielist in stream
      */

     public Stream<Movie> filterByTitle(List<Movie> movieList, String title) {

         List<Movie> filteredMovieList = new ArrayList<>();

         for (Movie movie : movieList){
             if (movie.getTitle().contains(title)){
                 filteredMovieList.add(movie);
             }
         }
//         List<Movie> filteredMovieList = movieList.stream().filter(movie -> movie.getTitle().contains(title)).collect(Collectors.toUnmodifiableList());
        return filteredMovieList.stream();

     }

     /**
      *
      * @param year search movie by year of release, if can find the movie from local stored json file,
      * then add the movie to the filtered movie list, if cannot find the move, then
      * add the movie to the saved local file in JSON format.
      * @return
      */

     public Stream<Movie> filterByYear(List<Movie> movieList, int year) {

         return movieList.stream().filter(movie -> movie.getYear() == year);
    }

    @Override
    public void reset() {
       filteredMovieList.clear();
    }


}
