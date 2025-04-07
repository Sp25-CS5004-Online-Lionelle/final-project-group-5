package student.view;

import student.model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The main JFrame view that implements the IView interface.
 * It connects ButtonCommands and MovieDisplay into a single window.
 */
public class JFrameView extends JFrame implements IView{

    private final ButtonCommands buttonPanel;
    //private final MovieDisplay movieDisplay = new MovieDisplay(); //placeholder???
    private final JLabel messageLabel;

    public JFrameView(){
        setTitle("Movie App Title TBD");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

         // testing a component added!
        add(new JLabel("Hello Test!"), BorderLayout.CENTER);

         // Initialize components
         buttonPanel = new ButtonCommands();
         //movieDisplay = new MovieDisplay();
         messageLabel = new JLabel(" ");  // For help and/or error messages


         //GUI components
        add(buttonPanel, BorderLayout.NORTH);
        //add(movieDisplay, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);
    }
    
    // IView Display Methods

    @Override
    public void showHelpMessage(String message) {
    messageLabel.setText(message);  
}


    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }

    @Override
    public void viewMovieCollection(List<Movie> movies) {
        //movieDisplay.updateMovieList(movies);
    }

    @Override
    public void viewMovieList(List<Movie> movies) {
        //movieDisplay.updateUserList(movies);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        messageLabel.setText(errorMessage);
    }

    // getter methods for input

    @Override
    public String getSearchQuery() {
        return ""; //buttonPanel.getSearchQuery();
    }

    @Override
    public String getSelectedFilter() {
        return ""; // buttonPanel.getSelectedFilter();
    }

    @Override
    public String getSelectedOperator() {
        return ""; //buttonPanel.getSelectedOperator();
    }

    @Override
    public boolean getSort() {
        return true; //buttonPanel.isSortAscending();
    }

    // button listeners 

    @Override
    public void addSearchListener(ActionListener listener) {
        //buttonPanel.addSearchListener(listener);
    }

    @Override
    public void addFilterListener(ActionListener listener) {
        //buttonPanel.addFilterListener(listener);
    }

    @Override
    public void addSortListener(ActionListener listener) {
        //buttonPanel.addSortListener(listener);
    }

    @Override
    public void addAddMovieListener(ActionListener listener) {
        //buttonPanel.addAddMovieListener(listener);
    }

    @Override
    public void addRemoveMovieListener(ActionListener listener) {
        //buttonPanel.addRemoveMovieListener(listener);
    }

    @Override
    public void addSaveListener(ActionListener listener) {
        //buttonPanel.addSaveListener(listener);
    }



}
