package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class MovieCollection implements IMovieCollection{

        /**
     * A set of all Movie objects.
     */
    private Set<Movie> movieRecords = new HashSet<>();

        /**
     * A list of filtered movies.
     */
    private List<Movie> filteredMovieList;

    /**
     * constructor. load all movies that saved in the local Json file.
     * @param database
     */
    public MovieCollection(String database) {
        try {
            loadMovieRecords(new FileInputStream(database));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(System.err);
        }
    }

    /**
     * add the movie records to the movieRecords set.
     * @param in
     */
    private void loadMovieRecords(InputStream in) {
        movieRecords.addAll(InputReader.readJSON(in, JSON));
    }


     @Override
     public Stream<Movie> filter(Operations operation) {
        // TODO Auto-generated method stub
        switch (operation) {
            case TITLE:
                return filterByTitle(title);
            case YEAR:
                return filterByYear(year);
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

     public Stream<Movie> filterByTitle(String title) {

        for (Movie movieRecord : movieRecords) {
            if (movieRecord.getTitle() == title){
                filteredMovieList.add(movieRecord);
            }
        }

        // if no movie's title in the local json file match the title, then we fetch from API
        if (filteredMovieList == 0){
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

     public Stream<Movie> filterByYear(int year) {
        for (Movie movieRecord : movieRecords) {
            if (movieRecord.getYear() == year){
                filteredMovieList.add(movieRecord);
            }
        }

        // if no movie's year in the local json file match the year, then we fetch from API
        if (filteredMovieList == 0){
            // look up movie by year of release
            // get movie details
            // add movie to the local file and then return the move

            throw new UnsupportedOperationException("Unimplemented method 'sort'");
        }
        return filteredMovieList.stream();
    }

     @Override
     public Stream<Movie> sort(Operations operation) {
       return  sort(operation, true);
     }

     @Override
     public Stream<Movie> sort(Operations operation, boolean ascending) {
        switch (operation) {
            case TITLE:
            if (ascending){
                filteredMovieList.sort((m1, m2) -> m1.geTitle().toLowerCase().compareTo(m2.getTitle().toLowerCase()));
            } else {
                filteredMovieList.sort((m1, m2) -> m2.geTitle().toLowerCase().compareTo(m1.getTitle().toLowerCase()));
            }
                return filteredMovieList;
            case ID:
            if (ascending) {
                filteredMovieList.sort((m1, m2) -> m1.getYear() - m2.getYear());
            } else {
                filteredMovieList.sort((m1, m2) -> m2.getYear() - m1.getYear());
            }
            default:
                return filteredMovieList;
        }
     }

     @Override
     public void reset() {
        filteredMovieList = movieRecords.stream().toList();
     }
}
