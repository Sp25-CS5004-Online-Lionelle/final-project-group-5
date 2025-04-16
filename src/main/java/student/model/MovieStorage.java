package student.model;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MovieStorage {


// ----------------------------------------------Update If Needed------------------------------------------------------
    private static final String DATABASE = "src/main/resources/movieList.json";
    /** The default output location.*/
    private static final String DEFAULT_OUTPUT_LOCATION = "src/main/resources/movieList.json";
// ----------------------------------------------Update If Needed------------------------------------------------------


// ===============================================Constructor==========================================================

    MovieStorage() { }

// =================================================Readers============================================================

    /**
     * Reads a JSON file and maps its content to an ArrayList of Movie objects.
     *
     * @return ArrayList containing movie objects of all movies in database.
     */
    public static List<Movie> readJSON(InputStream inputStream) {
        ObjectMapper mapper = new ObjectMapper();
        List<Movie> movies = new ArrayList<>();
        try {
            movies = mapper.readValue(inputStream, new TypeReference<List<Movie>>() { });
            return movies;
        } catch (IOException e) {
            e.printStackTrace();
            return movies;
        }
    }

    /**
     * Loads database in its current state at time of call.
     *
     * @return ArrayList containing movie objects of all movies in database.
     */
    public static List<Movie> loadDatabase() {
        try{
            return readJSON(new FileInputStream(DATABASE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads database in its current state at time of call.
     *
     * @return ArrayList containing movie objects of all movies in database.
     */
    public static List<Movie> loadUserSavedMovieList(String username) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String useMovieListFile = "src/main/resources/" + username.toLowerCase()
                                                                      .replace(" ", "") + ".json";
            FileInputStream inputStream = new FileInputStream(useMovieListFile);
            readJSON(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


// =================================================Writers============================================================

    /**
     *
     * @param movies A set of movies need to be written to JSON file
     */
    public static void writeJsonData(Set<Movie> movies){

        OutputStream out;
        try {
            out = new FileOutputStream(DEFAULT_OUTPUT_LOCATION);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(out, movies);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Takes in an ArrayList of Movie objects ArrayList<Movie> and writes it to a specified user's movie list.
     *
     * @param movieList a list of movie objects.
     * @param username name of user
     */
    public static void writeToUserMovieList(ArrayList<Movie> movieList, String username) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String outputFolder = "src/main/resources/" + username.toLowerCase()
                                                                  .replace(" ", "") + ".json";
            FileOutputStream out = new FileOutputStream(outputFolder);
            mapper.writeValue(out, movieList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes in an ArrayList of Movie objects ArrayList<Movie> and writes it to a default user's movie list.
     *
     * @param movieList a list of movie objects.
     */
    public static void writeToUserMovieList(ArrayList<Movie> movieList) {
        String defaultUsername = "userSavedLists";
        writeToUserMovieList(movieList, defaultUsername);
    }

}
