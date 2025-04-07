package student.controller;

 import student.model.*;
 import student.view.IView;
 import java.util.List;

 /**
  * MovieController is responsible for handling user interactions and updating the model and view accordingly.
  */
 public class MovieController implements IController {
     /**
      * The model representing the movie collection.
      */
     private final IMovieCollection model;
     /**
      * The user's movie list.
      */
     private final IMovieList userList;
     /**
      * The view for displaying information to the user.
      */
     private final IView view;

     /**
      * Constructor for MovieController.
      *
      * @param model   the movie collection model
      * @param userList the user's movie list
      * @param view    the view for displaying information
      */
     public MovieController(IMovieCollection model, IMovieList userList, IView view) {
         this.model = model;
         this.userList = userList;
         this.view = view;
     }

     @Override
     public void start() {
         // placeholder for starting the application
     }

     @Override
     public void handleSearch(String query) {
         try {
             List<Movie> results = model.getFilteredMovies(query);
             // code to update the view with search results
         } catch (Exception e) {
             view.showErrorMessage("Search failed: " + e.getMessage());
         }
     }

     @Override
     public void handleFilter(String filter, String operator, String value) {
         // placeholder for filtering logic
     }

     @Override
     public void handleSort(boolean ascending) {
         List<Movie> sorted = model.sortFilteredMovies(FilterType.TITLE, ascending); // default sort by title
         // code to update the view with sorted movies
     }

     @Override
     public void handleAddMovie(String movieTitle) {
         for (Movie movie : model.getMovies()) {
             if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                 userList.add(movie);
                 // code to update the view
                 return;
             }
         }
         view.showErrorMessage("Movie not found: " + movieTitle);
     }

     @Override
     public void handleRemoveMovie(String movieTitle) {
         for (Movie movie : userList.getMovies()) {
             if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                 userList.remove(movie);
                 // code to update the view
                 return;
             }
         }
         view.showErrorMessage("Movie not in saved list: " + movieTitle);
     }

     @Override
     public void handleSave(String fileType) {
         // placeholder for saving the movie list
     }
 }