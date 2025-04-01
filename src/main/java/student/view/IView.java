package student.view;

import student.model.Movie;
import java.util.List;
import java.awt.event.ActionListener;

public interface IView {void setVisible(boolean visible);  //visibility
    

    // view movie data
    void viewMovieCollection(List<Movie> movies);    //shows full movie collection
    void viewMovieList(List<Movie> movies);  //shows updated movieList
    void showErrorMessage(String errorMessage); //display error message to user

    // user input getters
    String getSearchQuery(); //search from text field
    String getSelectedFilter(); //get the selected filter (average rating, genre, year, cast member, etc )
    String getSelectedOperator(); // get the operator selected to apply to the search (>, <, ==. !=, ~= etc)
    boolean getSort(); // sort the filtered collection ascending or decsending


    //event listenters to connect view to controller
    //waiting for user action (click button, typing in field, dropdown menu)
    void addSearchListener(ActionListener listener);
    void addFilterListener(ActionListener listener);
    void addSortListener(ActionListener listener);
    void addAddMovieListener(ActionListener listener);
    void addRemoveMovieListener(ActionListener listener);
    void addSaveListener(ActionListener listener);
}

    
