package student.model;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


public class MovieCollection implements IMovieCollection{

        /**
     * A set of all Movie objects.
     */
    private Set<Movie> movieRecords = new HashSet<>();

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
        movieRecords.addAll(InputReader.readJSON(in, JSON));
    }



}
