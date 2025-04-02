package student.model;
import student.model.Movie;


import java.util.List;
import java.util.stream.Stream;

public class MovieSort implements IMovieSort{

    @Override
    public Stream<Movie> sort(List<Movie> filteredMovieList, FilterType filterType) {
        return  sort(filterType, true);
    }

    @Override
    public Stream<Movie> sort(List<Movie> filteredMovieList, FilterType filterType, boolean ascending) {
        switch (filterType) {
            case RATING:
            if (ascending){
                filteredMovieList.sort((m1, m2) -> Double.compare(m1.getAverageRating(), m2.getAverageRating()));
            } else {
                filteredMovieList.sort((m1, m2) -> Double.compare(m2.getAverageRating(), m1.getAverageRating()));
            }
                return filteredMovieList.stream();
            case YEAR:
            if (ascending) {
                filteredMovieList.sort((m1, m2) -> m1.getYear() - m2.getYear());
            } else {
                filteredMovieList.sort((m1, m2) -> m2.getYear() - m1.getYear());
            }
            default:

    }

    }
}