package student.view;

import student.model.Movie;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;

/**
 * The main JFrame for the Movie App.
 * Displays the ButtonCommands at the top and holds a split view of the movie collection and user movie list.
 */
public class JFrameView extends JFrame implements IView{
    UserMovieListPanel userListPanel;
    private ButtonCommands buttonPanel;
    private JSplitPane splitPane;
    private Consumer<Movie> removeAction = movie -> {};

public JFrameView(List<Movie> movies) {

        setTitle("Reel It In");
        setSize(1200, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Show the main window first
        this.setVisible(true); 

        JOptionPane.showMessageDialog(
            this,
            "<html><div style='text-align: center;'>🎬 <b>Welcome to our Movie App!</b><br><br>" +
            "Use the filter and sort options to explore movies.<br>" +
            "Add your favorites to a list and save them to a file!<br><br>" +
            "Click the help button if you get stuck!<br>" +
            "Enjoy browsing! </div></html>",
            "Welcome",
            JOptionPane.INFORMATION_MESSAGE
        );

         // top control panel
        buttonPanel = new ButtonCommands();
        add(buttonPanel, BorderLayout.NORTH);

        // Right panel (user's added movies). Starts out empty and is filled by adding
        // from movieGrid (left panel).
         userListPanel = new UserMovieListPanel(List.of(), "Remove", removeAction);
        

         // Left panel (movie collection grid)
         MovieGridDisplay movieGrid = new MovieGridDisplay(movies, movie -> {
            // Fake a search query and trigger the controller's existing add flow
            // Store the movie title in the search field so controller picks it up
            buttonPanel.setSearchQuery(movie.getTitle());
            // Trigger the add handler
            for (ActionListener listener : buttonPanel.getAddListeners()) {
                listener.actionPerformed(null);
            }
        });

        JScrollPane leftScrollPane = new JScrollPane(movieGrid);
    
        // Right: User Movie List Panel
        
        JScrollPane rightScrollPane = new JScrollPane(userListPanel);


        // Center: Split Pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        splitPane.setDividerLocation(600);
        add(splitPane, BorderLayout.CENTER);

         // Optional bottom message label
         JLabel messageLabel = new JLabel(" ");
         add(messageLabel, BorderLayout.SOUTH);
 
         setVisible(true);
     }

    @Override
    public void viewMovieCollection(List<Movie> movies) {
        MovieGridDisplay movieGrid = new MovieGridDisplay(movies, movie -> {
             buttonPanel.setSearchQuery(movie.getTitle());
             for (ActionListener listener : buttonPanel.getAddListeners()) {
                 listener.actionPerformed(null);
             }
        });
    
        JScrollPane leftScrollPane = new JScrollPane(movieGrid);
        JScrollPane rightScrollPane = new JScrollPane(userListPanel);
    
        if (splitPane != null) {
            getContentPane().remove(splitPane);  // safely remove only if it exists
        }
    
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        splitPane.setDividerLocation(600);
        add(splitPane, BorderLayout.CENTER);
    
        revalidate();
        repaint();
    }
     

@Override
public void viewMovieList(List<Movie> movies) {
    userListPanel.updateMovieList(movies); // update the user list panel with the new movies
}

@Override
public void showErrorMessage(String errorMessage) {
    JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
}

@Override
public void showHelpMessage(String helpMessage) {
    JOptionPane.showMessageDialog(this, helpMessage, "Help", JOptionPane.INFORMATION_MESSAGE);
}

@Override
public String getSearchQuery() {
    return buttonPanel.getSearchQuery();
}

@Override
public String getSelectedFilter() {
    return buttonPanel.getSelectedFilter();
}

@Override
public String getSelectedSort() {
        return buttonPanel.getSelectedSort();
    }

@Override
public String getSelectedOperator() {
    return buttonPanel.getSelectedOperator();
}

@Override
public boolean getSort() {
    return buttonPanel.isSortAscending();
}

@Override
public boolean getNotAscDec(){
    return buttonPanel.notAscDec();
}

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
    userListPanel.getSaveButton().addActionListener(listener);
}

public void addClearListener(ActionListener listener) {
    userListPanel.getClearButton().addActionListener(listener);
}

@Override
public void addHelpListener(ActionListener listener) {
    buttonPanel.addHelpListener(listener);
}

@Override
public void addAddAllListener(ActionListener listener) {
    buttonPanel.addAddAllListener(listener);
}

@Override
public void setRemoveAction(Consumer<Movie> removeAction) {
    this.removeAction = removeAction;
    userListPanel.setRemoveAction(removeAction);
}
}
 

