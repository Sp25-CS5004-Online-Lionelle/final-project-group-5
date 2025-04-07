import student.model.Movie;
import student.view.MovieDisplay;

import javax.swing.*;
import java.util.List;

public class TestMovieDisplay {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MovieDisplay Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 700);

            MovieDisplay display = new MovieDisplay();

            Movie ratatouille = new Movie(
                "Ratatouille",
                8.1,
                2007,
                "Animation, Adventure, Comedy",
                List.of("Brad Garrett", "Lou Romano", "Patton Oswalt"),
                "A rat who can cook makes an unusual alliance with a young kitchen worker at a famous Paris restaurant.",
                "https://m.media-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg"
            );

            display.setMovie(ratatouille);
            frame.add(display);
            frame.setVisible(true);
        });
    }
}
