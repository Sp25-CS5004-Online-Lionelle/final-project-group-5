package student.view;

import student.model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The main JFrame that implements the IView interface.
 * It connects ButtonCommands and MovieDisplay into a single window.
 */
public class JFrameView extends JFrame implements IView{

    private final ButtonCommands buttonPanel;
    private MovieGridDisplay movieGrid;
    private JScrollPane scrollPane;
    private final JLabel messageLabel;

    public JFrameView(){
        setTitle("Movie App Title TBD");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'>"
        + "🎬 Welcome to our Movie App!<br>"
        + "Use the filter and sort options to explore movies.<br>"
        + "Add your favorites to a list and save them to a file!"
        + "</div></html>", SwingConstants.CENTER);

         // Initialize components
         buttonPanel = new ButtonCommands();
         //movieDisplay = new MovieDisplay();
         add(welcomeLabel, BorderLayout.CENTER);
         messageLabel = new JLabel(" ");  // For help and/or error messages


         //GUI components
        add(buttonPanel, BorderLayout.NORTH);
        //add(movieDisplay, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);
        

        movieGrid = new MovieGridDisplay(List.of());  // Empty grid
        scrollPane = new JScrollPane(movieGrid);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);


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
        scrollPane.setViewportView(new MovieGridDisplay(movies));
        revalidate();
        repaint();
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
        return buttonPanel.getSearchQuery();
    }

    @Override
    public String getSelectedFilter() {
        return buttonPanel.getSelectedFilter();
    }

    @Override
    public String getSelectedOperator() {
        return buttonPanel.getSelectedOperator();
    }

    @Override
    public boolean getSort() {
        return buttonPanel.isSortAscending();
    }

    // button listeners 


    @Override
    public void addFilterListener(ActionListener listener) {
        buttonPanel.addFilterListener(listener);
    }

    @Override
    public void addSortListener(ActionListener listener) {
        buttonPanel.addSortListener(listener);
    }

    @Override
    public void addAddMovieListener(ActionListener listener) {
        buttonPanel.addAddMovieListener(listener);
    }

    @Override
    public void addRemoveMovieListener(ActionListener listener) {
        buttonPanel.addRemoveMovieListener(listener);
    }

    @Override
    public void addSaveListener(ActionListener listener) {
        buttonPanel.addSaveListener(listener);
    }
    @Override
    public void addHelpListener(ActionListener listener) {
        buttonPanel.addHelpListener(listener);
    }


}
