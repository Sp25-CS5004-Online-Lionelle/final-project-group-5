
import java.util.List;
import student.view.*;
import student.model.Movie;
//Rowan's main test file for the JFrameView full GUI.... I know it's the wrong folder and name, will move it before we're done. 

public class TestJFrameView {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            
            

             // Sample movies to display
            List<Movie> sampleMovies = List.of(
                new Movie("Ratatouille", 8.1, 2007, List.of("Animation", "Family"),
                    List.of("Patton Oswalt", "Brad Garrett"),
                    "A rat who can cook makes an alliance with a kitchen worker.",
                    "https://m.media-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg"
                ),
                new Movie("The Godfather", 9.2, 1972, List.of("Crime", "Drama"),
                    List.of("Marlon Brando", "Al Pacino", "James Caan"),
                    "The aging patriarch of an organized crime dynasty transfers control of his empire to his reluctant son.",
                    "https://m.media-amazon.com/images/M/MV5BNGEwYjgwOGQtYjg5ZS00Njc1LTk2ZGEtM2QwZWQ2NjdhZTE5XkEyXkFqcGc@._V1_SX300.jpg"
                ),
                new Movie("The Shawshank Redemption", 9.3, 1994, List.of("Drama"),
                List.of("Tim Robbins", "Morgan Freeman"),
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmRhMC00ZDJlLTgwNzYtN2Y1ZDJmZGU3N2JhXkEyXkFqcGc@._V1_SX300.jpg"),
                
                new Movie("Back to the Future", 8.5, 1985, List.of("Adventure", "Sci-Fi", "Comedy"),
                List.of("Michael J. Fox", "Christopher Lloyd"),
                "Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean.",
                "https://upload.wikimedia.org/wikipedia/en/d/d2/Back_to_the_Future.jpg")
                                
        );
        //create the view
        JFrameView view = new JFrameView(sampleMovies);


    // Show them in the main view
    view.viewMovieCollection(sampleMovies);

});
}
}



