package student.model;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;


public class MovieCollection implements IMovieCollection{

    /**
     * A set of all Movie objects in the local file.
     */
    private Set<Movie> movieRecords;

    /**
     * A list if filtered movie objects
     */
    List<Movie> filteredMovieList = new ArrayList<>();


    /**
     * constructor. load all movies that saved in the local Json file. The movie sorted in ascending order by title
     */
        public MovieCollection() {
            this.movieRecords = new TreeSet<>(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER));
            movieRecords.addAll(MovieStorage.loadDatabase());
        }

    /**
     * Get all movies in the movie collection
     * @return all movies in the movie collection
     */

	@Override
	public List<Movie> getMovies() {
        // Convert Set to List
        List<Movie> movieList = new ArrayList<>(movieRecords);
        return movieList;

    }

    @Override
    public List<Movie> getFilteredMovies(String value, Operations op, FilterType filterType){

        MovieFilter movieFilter = new MovieFilter();
        filteredMovieList = movieFilter.filter(this.getMovies(), op, filterType, value).collect(Collectors.toList());
//        MovieSort movieSort = new MovieSort();
        if (filteredMovieList.isEmpty()) {
            if (filterType.equals(FilterType.YEAR) || filterType.equals(FilterType.GENRE) || filterType.equals(FilterType.DESCRIPTION)) {
                throw new IllegalArgumentException("No movies found");
            }
            try {
                ObjectMapper mapper = new ObjectMapper();
                Movie movie = mapper.readValue(OMDBMovieData.getMovieDetails(value), Movie.class);
                movieRecords.add(movie);
                filteredMovieList.add(movie);
                MovieStorage.writeJsonData(movieRecords);
            } catch (StreamReadException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return filteredMovieList;
    }

    @Override
    public List<Movie> getFilteredMovieList(){
        return this.filteredMovieList;
    }

    /**
     * To sort the filtered movies by a sort type
     * @param sortType the type we need to the sort base on, such as RATING, YEAR
     * @param ascending if we want to sort movies in ascending or descending order
     * @return  a list of sorted filtered movies
     */

    public List<Movie> sortFilteredMovies(FilterType sortType, boolean ascending ){
        MovieSort movieSort = new MovieSort();
        List<Movie> sortedFilteredMovie = movieSort.sort(this.filteredMovieList, sortType, ascending);

        return sortedFilteredMovie;
    }
    @Override
    public void reset() {
        filteredMovieList.clear();
    }



}
