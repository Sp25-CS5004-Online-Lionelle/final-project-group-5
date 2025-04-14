package student;

 import student.controller.IController;
 import student.controller.MovieController;
 import student.model.IMovieCollection;
 import student.model.IMovieList;
 import student.model.MovieCollection;
 import student.model.MovieList;
 import student.view.IView;
 import student.view.JFrameView; 

 public class MovieApp {

     public static void main(String[] args) {
         // Set up model
         IMovieCollection model = new MovieCollection();

         // User’s saved movie list
         IMovieList userList = new MovieList();

         // Set up view 
         IView view = new JFrameView(model.getMovies());

         // Connect model and view via controller
         IController controller = new MovieController(model, userList, view);

         // Launch the app
         controller.start();
     }
 }