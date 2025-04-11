package student.view;

import student.model.Movie;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * MovieGridDisplay displays a list of MovieCardPanel components in a grid layout.
 * Used on the left side of the GUI for the MovieCollection to filter
 */
public class MovieGridDisplay extends JPanel {

    /**
     * Constructs the MovieGridDisplay panel with given list of movies.
     *
     * @param movies List of Movie objects to display as cards.
     */
    public MovieGridDisplay(List<Movie> movies, Consumer<Movie> addAction) {
        // Set the layout manager for the panel
        setLayout(new GridLayout(0, 3, 20, 20)); ;
        setBackground(Color.WHITE);

        setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.GRAY),
        "Movie Collection",
        TitledBorder.CENTER,
        TitledBorder.TOP
            ));

        // Add each movie card to the panel
        for (Movie movie : movies) {
            MovieCardPanel card = new MovieCardPanel(movie, "Add");
            add(card);
        }
    }
}
