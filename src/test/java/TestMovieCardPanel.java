import student.model.Movie;
import student.view.MovieCardPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TestMovieCardPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Movie Card Panel Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Sample movie data
            List<Movie> sampleMovies = List.of(
                new Movie("Ratatouille", 8.1, 2007, "Animation",
                        List.of("Patton Oswalt", "Brad Garrett"),
                        "A rat who can cook makes an alliance with a kitchen worker.",
                        "https://m.media-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg"),
                new Movie("The Godfather", 9.2, 1972, "Crime, Drama",
                        List.of("Marlon Brando", "Al Pacino", "James Caan"),
                        "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                        "https://m.media-amazon.com/images/M/MV5BNGEwYjgwOGQtYjg5ZS00Njc1LTk2ZGEtM2QwZWQ2NjdhZTE5XkEyXkFqcGc@._V1_SX300.jpg")
            );

            // Grid layout
            JPanel gridPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
            for (Movie movie : sampleMovies) {
                gridPanel.add(new MovieCardPanel(movie));
            }

            JScrollPane scrollPane = new JScrollPane(gridPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            frame.add(scrollPane);

            frame.setVisible(true);
        });
    }
}
