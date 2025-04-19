package student.model;
import student.model.Movie;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MovieSort implements IMovieSort{

    @Override
    public List<Movie> sort(List<Movie> filteredMovieList, FilterType filterType) {
        return sort(filteredMovieList, filterType, true);
    }

    @Override
    public List<Movie> sort(List<Movie> filteredMovieList, FilterType filterType, boolean ascending) {
        List<Movie> sortedFilteredMovies = new ArrayList<>(filteredMovieList);
        switch (filterType) {
            case TITLE:
            if (ascending)  {
                sortedFilteredMovies.sort((m1, m2) -> m1.getTitle().toLowerCase().compareTo(m2.getTitle().toLowerCase()));
            } else {
                sortedFilteredMovies.sort((m1, m2) -> m2.getTitle().toLowerCase().compareTo(m1.getTitle().toLowerCase()));
            }
            return sortedFilteredMovies;
            case RATING:
            if (ascending){
                sortedFilteredMovies.sort((m1, m2) -> Double.compare(m1.getAverageRating(), m2.getAverageRating()));
            } else {
                sortedFilteredMovies.sort((m1, m2) -> Double.compare(m2.getAverageRating(), m1.getAverageRating()));
            }
                return sortedFilteredMovies;
            case YEAR:
            if (ascending) {
                sortedFilteredMovies.sort((m1, m2) -> m1.getYear() - m2.getYear());
            } else {
                sortedFilteredMovies.sort((m1, m2) -> m2.getYear() - m1.getYear());
            }
            return sortedFilteredMovies;
            default:
            return sortedFilteredMovies;

    }

    }
}