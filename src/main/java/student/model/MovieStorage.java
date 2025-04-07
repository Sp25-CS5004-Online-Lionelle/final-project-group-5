package student.model;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MovieStorage implements IStorage {


// ----------------------------------------------Update If Needed------------------------------------------------------
    private static final String DATABASE = "src/main/resources/database.json";
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
        try {
            List<Movie> movies = mapper.readValue(inputStream, new TypeReference<List<Movie>>() { });
            return movies;
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
    public static List<Movie> loadDatabase() {
        try{
            readJSON(new FileInputStream(DATABASE));
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
     * Takes in JSON movie content and appends it to a JSON database of other movies.
     *
     * @param in An input stream of JSON information
     */
    public static void appendNewMovieJsonToDatabase(InputStream in) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            List<Movie> currentDatabase = new ArrayList<>(loadDatabase());
            List<Movie> movieToAppend = new ArrayList<>(readJSON(in));
            currentDatabase.addAll(movieToAppend);

            FileOutputStream out = new FileOutputStream(DATABASE);
            mapper.writeValue(out, currentDatabase);
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
