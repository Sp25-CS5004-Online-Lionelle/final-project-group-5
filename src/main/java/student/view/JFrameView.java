package student.view;

import student.model.Movie;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The main JFrame for the Movie App.
 * Displays the ButtonCommands at the top and holds a split view of the movie collection and user movie list.
 */
public class JFrameView extends JFrame implements IView{
    UserMovieListPanel userListPanel;
    private ButtonCommands buttonPanel;
    private JSplitPane splitPane;
    private List<Movie> userList = new ArrayList<>();

public JFrameView(List<Movie> movies) {

        setTitle("Movie App");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Show the main window first
        this.setVisible(true); 

        JOptionPane.showMessageDialog(
            this,
            "<html><div style='text-align: center;'>🎬 <b>Welcome to our Movie App!</b><br><br>" +
            "Use the filter and sort options to explore movies.<br>" +
            "Add your favorites to a list and save them to a file!<br><br>" +
            "Enjoy browsing! </div></html>",
            "Welcome",
            JOptionPane.INFORMATION_MESSAGE
        );

         // top control panel
        buttonPanel = new ButtonCommands();
        add(buttonPanel, BorderLayout.NORTH);

       // User list to track added movies (starts empty)
        userList = new ArrayList<>();

        userListPanel = new UserMovieListPanel(List.of(), "Remove", movie -> {
            userList.remove(movie);
            userListPanel.updateMovieList(userList);
        });
        

         // Left panel (movie collection grid)
         MovieGridDisplay movieGrid = new MovieGridDisplay(movies, movie -> {
            if (!userList.contains(movie)) {
                userList.add(movie);
                userListPanel.updateMovieList(userList);
            }
        });

        JScrollPane leftScrollPane = new JScrollPane(movieGrid);
    
        // Right: User Movie List Panel
        
        JScrollPane rightScrollPane = new JScrollPane(userListPanel);
        
        // Update user list when a movie is removed
        userListPanel.getClearButton().addActionListener(e -> {
            userList.clear();
            userListPanel.updateMovieList(userList);
        });

        // Center: Split Pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        splitPane.setDividerLocation(500);
        add(splitPane, BorderLayout.CENTER);

         // Optional bottom message label
         JLabel messageLabel = new JLabel(" ");
         add(messageLabel, BorderLayout.SOUTH);
 
         setVisible(true);
     }

    @Override
    public void viewMovieCollection(List<Movie> movies) {
        MovieGridDisplay movieGrid = new MovieGridDisplay(movies, movie -> {
            if (!userList.contains(movie)) {
                userList.add(movie);
                userListPanel.updateMovieList(userList);
            }
        });
    
        JScrollPane leftScrollPane = new JScrollPane(movieGrid);
        JScrollPane rightScrollPane = new JScrollPane(userListPanel);
    
        if (splitPane != null) {
            getContentPane().remove(splitPane);  // safely remove only if it exists
        }
    
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        splitPane.setDividerLocation(500);
        add(splitPane, BorderLayout.CENTER);
    
        revalidate();
        repaint();
    }
     

@Override
public void viewMovieList(List<Movie> movies) {
    this.userList = new ArrayList<>(movies);
    userListPanel.updateMovieList(userList);
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
public String getSelectedOperator() {
    return buttonPanel.getSelectedOperator();
}

@Override
public boolean getSort() {
    return buttonPanel.isSortAscending();
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

@Override
public void addHelpListener(ActionListener listener) {
    buttonPanel.addHelpListener(listener);
}
 }
 

