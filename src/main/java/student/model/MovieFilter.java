package student.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieFilter implements IMovieFilter{


        /**
     * A list of filtered movies.
     */

    @Override
     public Stream<Movie> filter(List<Movie> movieList, Operations op, FilterType filterType, String value) {
        // TODO Auto-generated method stub
        switch (filterType) {
            case TITLE:
                return filterByTitle(movieList, op, value);
            case GENRE:
                return filterByGenre(movieList, op, value);
            case DESCRIPTION:
                return filterByDesc(movieList, op, value);
            case YEAR:
                return filterByYear(movieList, op, Integer.parseInt(value));
            default:
                return movieList.stream(); // will update this later, currently return an empty stream.
        }

     }

     /**
      *
      * @param title search movie by title, if the operation contains, then it will find a movie with a title
      *              contains the searched title.
      *              If the operation is equal, it will find a movie with a title equals the searched movie title.
      * @return the filtered movielist in stream
      */

     public Stream<Movie> filterByTitle(List<Movie> movieList, Operations op, String title) {
         switch (op) {
             case EQUALS:
                 return movieList.stream()
                         .filter(m -> m.getTitle().equalsIgnoreCase(title));
             case CONTAINS:
                 return movieList.stream()
                         .filter(m -> m.getTitle().toLowerCase().contains(title.toLowerCase()));
             default:
                 return movieList.stream();
         }
     }

    public Stream<Movie> filterByGenre(List<Movie> movieList, Operations op, String genre) {
        switch (op) {
            case EQUALS:
                return movieList.stream()
                        .filter(m -> m.getGenre().stream().anyMatch(g -> g.equalsIgnoreCase(genre)));
            case CONTAINS:
                return movieList.stream()
                        .filter(m -> m.getGenre().stream().anyMatch(g -> g.toLowerCase().contains(genre.toLowerCase())));
            default:
                return movieList.stream();
        }
    }

     /**
      *
      * @param year search movie by year of release, if can find the movie from local stored json file,
      * then add the movie to the filtered movie list, if cannot find the move, then
      * add the movie to the saved local file in JSON format.
      * @return
      */

     public Stream<Movie> filterByYear(List<Movie> movieList, Operations op, int value) {

         switch (op) {
             case EQUALS:
                 return movieList.stream().filter(movie -> movie.getYear() == value);
             case NOT_EQUALS:
                 return movieList.stream().filter(movie -> movie.getYear() != value);
             case GREATER_THAN:
                 return movieList.stream().filter(movie -> movie.getYear() > value);
             case LESS_THAN:
                 return movieList.stream().filter(movie -> movie.getYear() < value);
             case GREATER_THAN_EQUAL:
                 return movieList.stream().filter(movie -> movie.getYear() >= value);
             case LESS_THAN_EQUAL:
                 return movieList.stream().filter(movie -> movie.getYear() <= value);
             default:
                 return movieList.stream();
         }
    }


//
//    @Override
//    public void reset() {
//       filteredMovieList.clear();
//    }


}
