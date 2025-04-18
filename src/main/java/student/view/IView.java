package student.view;

import student.model.Movie;
import java.util.List;
import java.awt.event.ActionListener;

public interface IView {
     /**
     * Sets the visibility of the GUI window.
     *
     * @param visible true to show the view, false to hide it
     */
    void setVisible(boolean visible);  
    

    /**
     * Displays the full movie collection or filtered once user applies filter or sort.
     *
     * @param movies the list of all movies retrieved from the API or data source
     */
    void viewMovieCollection(List<Movie> movies);

    /**
     * Displays the user's personalized movie list in the view once they add or remove movies. 
     *
     * @param movies the list of movies the user has added to their saved list
     */
    void viewMovieList(List<Movie> movies);  

    /**
     * Displays an error message to the user 
     *
     * @param errorMessage the message to be shown
     */
    void showErrorMessage(String errorMessage); 

       /**
     * Displays an help message to the user 
     *
     * @param helpMessage the message to be shown
     */
    void showHelpMessage(String helpMessage); 

    // user input getters

    /**
     * Returns the current text input from the search/filter field.
     *
     * @return the text entered by the user
     */
    String getSearchQuery(); 
    /**
     * Returns the selected filter parameter (e.g., average rating, genre, year).
     *
     * @return the filter field selected by the user
     */
    String getSelectedFilter();


    /**
     * Retuens the selected sort parameter (e.g. year, IMDB Rating)
     * @return the sorted filter by the user in a String type
     */
    String getSelectedSort();

    /**
     * Returns the selected comparison operator (e.g., ==, >=, <=).
     *
     * @return the operator selected by the user
     */
    String getSelectedOperator(); // get the operator selected to apply to the search (>, <, ==. !=, ~= etc)

     /**
     * Returns the sort direction.
     *
     * @return true for ascending sort, false for descending
     */
    boolean getSort(); // sort the filtered collection ascending or decsending

    /**
     * check if Asc or Dec button is checked
     * @return
     */
    boolean getNotAscDec();
    //event listenters to connect view to controller
    //waiting for user action (click button, typing in field, dropdown menu)


     /**
     * Registers a listener for the filter action.
     *
     * @param listener the ActionListener to be notified when the filter is applied
     */
    void addFilterListener(ActionListener listener);

    /**
     * Registers a listener for the sort action.
     *
     * @param listener the ActionListener to be notified when sorting is selected
     */
    void addSortListener(ActionListener listener);


     /**
     * Registers a listener for the "Add to List" button.
     *
     * @param listener the ActionListener to be notified when a movie is added to the user's list
     */
    void addAddMovieListener(ActionListener listener); 

      /**
     * Registers a listener for the "Remove from List" button.
     *
     * @param listener the ActionListener to be notified when a movie is removed from the user's list
     */
    void addRemoveMovieListener(ActionListener listener);

     /**
     * Registers a listener for the "Save to File" action.
     *
     * @param listener the ActionListener to be notified when the save button is clicked
     */
    void addSaveListener(ActionListener listener);

    /**
* Registers a listener for the "Help" button.
 *
 * @param listener the ActionListener to be notified when the help button is clicked
 */
void addHelpListener(ActionListener listener);

/**
* Registers a listener for the "add all" button.
* 
* @param listener the ActionListener to be notified when the add all button is clicked
*/
void addAddAllListener(ActionListener listener);




}

    
