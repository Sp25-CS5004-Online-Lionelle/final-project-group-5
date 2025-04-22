package student.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MovieFilter implements IMovieFilter{


    /**
     *
     * @param movieList the list of movies to be filtered
     * @param op operations, such as CONTAINS, EQUALS, etc
     * @param filterType, filterType, such as TITLE, YEAR, etc
     * @param value, THE value to filter based on
     * @return a stream of movie
     */

    @Override
     public Stream<Movie> filter(List<Movie> movieList, Operations op, FilterType filterType, String value) {
        // TODO Auto-generated method stub

        switch (filterType) {
            case TITLE:
                if(value.isEmpty()) {
                    throw new IllegalArgumentException("Please enter a title");
                }
                return filterByTitle(movieList, op, value);
            case GENRE:
                if(value.isEmpty()) {
                    throw new IllegalArgumentException("Please enter a Genre");
                }
                return filterByGenre(movieList, op, value);
            case DESCRIPTION:
                if(value.isEmpty()) {
                    throw new IllegalArgumentException("Please some description");
                }
                return filterByDesc(movieList, op, value);
            case YEAR:
                if(value.contains(".")) {
                    throw new IllegalArgumentException("Invalid year format");
                } else if (value.isEmpty()) {
                    throw new IllegalArgumentException("Please enter a year");
                }
                return filterByYear(movieList, op, Integer.parseInt(value));
            default:
                return movieList.stream(); // will update this later, currently return an empty stream.
        }

     }

    /**
     *
     * @param movieList the list of movies to be filtered
     * @param op operations, such as CONTAINS, EQUALS, etc
     * @param title the description to filter based on
     * @return a stream of movie
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

    /**
     *
     * @param movieList the list of movies to be filtered
     * @param op operations, such as CONTAINS, EQUALS, etc
     * @param genre the description to filter based on
     * @return a stream of movie
     */

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
     * @param movieList the list of movies to be filtered
     * @param op operations, such as CONTAINS, EQUALS, etc
     * @param desc the description to filter based on
     * @return a  stream of movie
     */

    public Stream<Movie> filterByDesc(List<Movie> movieList, Operations op, String desc) {

        List<Movie> filteredMovieList = new ArrayList<>();

        for (Movie movie : movieList){
            if (movie.getDescription().contains(desc)){
                filteredMovieList.add(movie);
            }
        }
        return filteredMovieList.stream();
    }

    /**
     *
     * @param movieList
     * @param op
     * @param value
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
}
