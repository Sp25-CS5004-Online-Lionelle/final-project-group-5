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
        ButtonCommands buttonPanel = new ButtonCommands();
        add(buttonPanel, BorderLayout.NORTH);

       // User list to track added movies (starts empty)
        List<Movie> userList = new ArrayList<>();

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
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        splitPane.setDividerLocation(500);
        add(splitPane, BorderLayout.CENTER);

         // Optional bottom message label
         JLabel messageLabel = new JLabel(" ");
         add(messageLabel, BorderLayout.SOUTH);
 
         setVisible(true);
     }

@Override
public void viewMovieCollection(List<Movie> movies) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'viewMovieCollection'");
}

@Override
public void viewMovieList(List<Movie> movies) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'viewMovieList'");
}

@Override
public void showErrorMessage(String errorMessage) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showErrorMessage'");
}

@Override
public void showHelpMessage(String helpMessage) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showHelpMessage'");
}

@Override
public String getSearchQuery() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSearchQuery'");
}

@Override
public String getSelectedFilter() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSelectedFilter'");
}

@Override
public String getSelectedOperator() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSelectedOperator'");
}

@Override
public boolean getSort() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSort'");
}

@Override
public void addFilterListener(ActionListener listener) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addFilterListener'");
}

@Override
public void addSortListener(ActionListener listener) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addSortListener'");
}

@Override
public void addAddMovieListener(ActionListener listener) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addAddMovieListener'");
}

@Override
public void addRemoveMovieListener(ActionListener listener) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addRemoveMovieListener'");
}

@Override
public void addSaveListener(ActionListener listener) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addSaveListener'");
}

@Override
public void addHelpListener(ActionListener listener) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addHelpListener'");
}
 }
 

        