package student.model;

import java.util.List;
import java.util.stream.Stream;

public class MovieFilter implements IMovieFilter{


        /**
     * A list of filtered movies.
     */
    private List<Movie> filteredMovieList;

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

        for (Movie movie : movieList) {
            if (movie.getTitle() == title){
                filteredMovieList.add(movie);
            }
        }

        // if no movie's title in the local json file match the title, then we fetch from API
        if (filteredMovieList.size() == 0){
            // look up movie by Title
            // get movie details
            // add movie to the local file and then return the move

            throw new UnsupportedOperationException("Unimplemented method 'sort'");
        }
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
        for (Movie movie : movieList) {
            if (movie.getYear() == year){
                filteredMovieList.add(movie);
            }
        }

        // if no movie's year in the local json file match the year, then we fetch from API
        if (filteredMovieList.size() == 0){
            // look up movie by year of release
            // get movie details
            // add movie to the local file and then return the move

            throw new UnsupportedOperationException("Unimplemented method 'sort'");
        }
        return filteredMovieList.stream();
    }

    @Override
    public void reset() {
       filteredMovieList.clear();
    }


}
