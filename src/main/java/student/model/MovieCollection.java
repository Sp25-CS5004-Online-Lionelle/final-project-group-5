package student.model;


import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Filter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;


public class MovieCollection implements IMovieCollection{

    /**
     * A set of all Movie objects in the local file.
     */
    private Set<Movie> movieRecords = new HashSet<>();

    List<Movie> filteredMovieList = new ArrayList<>();

    /**
     * constructor. load all movies that saved in the local Json file.
     * @param database
     */
    public MovieCollection(String database) {
        try {
            loadMoives(new FileInputStream(database));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(System.err);
        }
    }

    /**
     * add the movie records to the movieRecords set.
     * @param in
     */
    private void loadMoives(InputStream in) {
        ObjectMapper mapper = new JsonMapper();
        List<Movie> movieList = new ArrayList<>();
       try {
        movieList = mapper.readValue(in, new TypeReference<List<Movie>>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }
        movieRecords.addAll(movieList);
    }

	@Override
	public List<Movie> getMovies() {
        // Convert Set to List
        List<Movie> movieList = new ArrayList<>(movieRecords);
        return movieList;

    }
//	@Override
//	public Stream<Movie> getMovie(String title) {
//		List<Movie> movieList = this.getMovies();
//        MovieFilter movieFilter = new MovieFilter();
//        return movieFilter.filter(movieList, FilterType.TITLE, title);
//	}
    @Override
    public List<Movie> getFilteredMovies(String value, Operations op, FilterType filterType){

        MovieFilter movieFilter = new MovieFilter();
        filteredMovieList = movieFilter.filter(this.getMovies(), op, filterType, value).collect(Collectors.toList());
//        MovieSort movieSort = new MovieSort();
        if (filteredMovieList.isEmpty()) {
            System.out.println("No movies found");
            try{  ObjectMapper mapper = new ObjectMapper();
                Movie movie = mapper.readValue(OMDBMovieData.getMovieDetails(value), Movie.class);
                movieRecords.add(movie);
                filteredMovieList.add(movie);
            }catch (StreamReadException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return filteredMovieList;
    }


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
