package student.controller;

import student.model.FilterType;
import student.model.Operations;

public interface IController {

    /**
     * Starts the application.
     * Wires up listeners and shows the view.
     */
    void start();

    /**
     * Handle user-initiated search.
     * @param value the search text (movie title, keyword, genre etc.)
     * @param op the operation type (EQUALS, CONTAINS, etc.)
     * @param filterType the filterType type (GENRE, RATING, YEAR, TITLE, DESCRIPTION;)
     */
    void handleSearch(String value, Operations op, FilterType filterType);

    /**
     * Handle filtering based on parameter/operator/value.
     * @param filter the attribute to filter by (e.g., "rating", "genre")
     * @param operator comparison operator (e.g., "==", ">=")
     * @param value the value to filter against
     */
    void handleFilter(String filter, String operator, String value);

    /**
     * Handle sorting of the movie collection.
     * @param ascending true for ascending order, false for descending
     */
    void handleSort(FilterType filterType, boolean ascending);

    /**
     * Add a selected movie to the user's saved movie list.
     * @param movieTitle the title of the movie to add
     */
    void handleAddMovie(String movieTitle);

    /**
     * Remove a movie from the user's saved movie list.
     * @param movieTitle the title of the movie to remove
     */
    void handleRemoveMovie(String movieTitle);

    /**
     * reset the movies in the movieCollection
     */
    void handleResetMovieCollection();


    /**
     * Save the user's movie list to a file in the chosen format.
     * @param fileType the file format to use.
     */
    void handleSave(String fileType);
    
} 
