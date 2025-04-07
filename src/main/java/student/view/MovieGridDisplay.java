package student.view;

import student.model.Movie;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * MovieGridDisplay displays a list of MovieCardPanel components in a grid layout.
 */
public class MovieGridDisplay extends JPanel {

    /**
     * Constructs the MovieGridDisplay panel with given list of movies.
     *
     * @param movies List of Movie objects to display as cards.
     */
    public MovieGridDisplay(List<Movie> movies) {
        // Set the layout manager for the panel
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        setBackground(Color.WHITE);

        // Add each movie card to the panel
        for (Movie movie : movies) {
            add(new MovieCardPanel(movie));
        }
    }
}
