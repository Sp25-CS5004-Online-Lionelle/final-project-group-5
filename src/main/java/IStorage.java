import java.io.FileWriter;

public interface IStorage {

    /**
     * Takes a movie collection and writes it to a JSON file to store for Non-API access at later points.
     * @param movieCollecition
     */
    public void writeToFileJSON(MovieCollecition movieCollecition);


    /**
     * Takes a single movie and appends it to the movie collection file.
     * @param movie
     */
    public void addMovieToFile(Movie movie);

    /**
     * Takes a single movie and appends it to user movie collection file.
     * @param movie
     * @param username
     */
    public void addMovieToUserFile(Movie movie, String username);

    /**
     * Will check to see if the movie already exists in the movie collection file
     * @param movie
     * @return
     */
    private boolean exitstsInMovieFile(Movie movie) {

        // Probably need to redo, but private methods need bodies in Interfaces
        for (String line: json) {
            if (movie.getTitle().compareTo(json) == 0) {
                return true;
            }
        }
        return false;
    }
}
