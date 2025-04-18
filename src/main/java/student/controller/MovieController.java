package student.controller;

 import student.model.*;
 import student.view.IView;

 import java.util.ArrayList;
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

     private List<Movie> results = new ArrayList<>();
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
        view.setVisible(true);
        view.viewMovieCollection(model.getMovies());

        view.addFilterListener(e -> handleFilter(
                view.getSelectedFilter(),
                view.getSelectedOperator(),
                view.getSearchQuery()
        ));

        view.addSortListener(e -> {
            if (view.getSelectedSort().toUpperCase().equalsIgnoreCase("year")){
                handleSort(
                        FilterType.YEAR,
                        view.getSort()
                );
            } else if (view.getSelectedSort().toUpperCase().equalsIgnoreCase("IMDB RATING")){
                handleSort(
                        FilterType.RATING,
                        view.getSort()
                );
            }

        });

        view.addResetCollectionListener(e -> handleResetMovieCollection());


        view.addAddMovieListener(e -> handleAddMovie(view.getSearchQuery()));
        view.addRemoveMovieListener(e -> {
            String title = e.getActionCommand();
            handleRemoveMovie(title);            
        });
        

        view.addAddAllListener(e -> {
            List<Movie> toAdd = results.isEmpty() ? model.getMovies() : results;
            System.out.println("Before addAll, userList has: " + userList.getMovieTitles());
            userList.addAll(toAdd);
            System.out.println("After addAll, userList has: " + userList.getMovieTitles());
            view.viewMovieList(userList.getMovies());
        });

        view.addHelpListener(e -> view.showHelpMessage("Use filters to narrow down movies. Click sort to reorder. Add to build your list."));
    }
    

     @Override
     public void handleSearch(String value, Operations op, FilterType filterType) {
         try {
             results = model.getFilteredMovies(value, op, filterType);
             view.viewMovieCollection(results);
         } catch (Exception e) {
             view.showErrorMessage("Search failed: " + e.getMessage());
         }
     }

     @Override
     public void handleFilter(String filter, String operator, String value) {
        try {
            FilterType filterType = FilterType.valueOf(filter.toUpperCase());
            Operations op = Operations.fromOperator(operator);
            results = model.getFilteredMovies(value, op, filterType);
            view.viewMovieCollection(results);
        } catch (Exception e) {
            view.showErrorMessage("Filter failed: " + e.getMessage());
        }
     }

     @Override
     public void handleSort(FilterType filterType, boolean ascending) {
         if (model.getFilteredMovieList().size() == 0){
             view.showErrorMessage("Please search some movies to sort");
             return;
         }
         if (view.getNotAscDec()){
             view.showErrorMessage("You must check sort Ascending or Descending");
             return;
         }
        try {
            results = model.sortFilteredMovies(filterType, ascending);
            view.viewMovieCollection(results);
        } catch (Exception e) {
            view.showErrorMessage("Sort failed: " + e.getMessage());
        }
     }

     @Override
    public void handleAddMovie(String movieTitle) {
    System.out.println("Attempting to add movie with title: \"" + movieTitle + "\""); // DEBUG
    // DEBUG: Log what's currently in the model
    System.out.println(" Available in model:");
    for (Movie m : model.getMovies()) {
        System.out.println(" - " + m.getTitle());
    }
    // DEBUG: Log user list before
    System.out.println("User list before adding:");
    for (Movie m : userList.getMovies()) {
        System.out.println(" - " + m.getTitle());
    }

    for (Movie movie : model.getMovies()) {
        if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
            userList.add(movie);
            System.out.println("Movie added to user list: " + movie.getTitle()); // DEBUG
            view.viewMovieList(userList.getMovies());
            return;
        }
    }

    // Log user list after (if not found)
    System.out.println("Movie not found in model: " + movieTitle); // DEBUG
    view.showErrorMessage("Movie not found: " + movieTitle); // DEBUG
}

     @Override
    public void handleRemoveMovie(String movieTitle) {
    System.out.println("Attempting to remove movie with title: \"" + movieTitle + "\"");

    // DEBUG: List what's currently in the user list
    System.out.println("Current user list:");
    for (Movie movie : userList.getMovies()) {
        System.out.println(" - " + movie.getTitle());
    }

    for (Movie movie : userList.getMovies()) {
        if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
            userList.remove(movie);
            System.out.println(" Movie removed from user list: " + movie.getTitle()); // DEBUG
            view.viewMovieList(userList.getMovies());
            return;
        }
    }

    // If not found
    System.out.println(" Movie not found in user list: " + movieTitle);
    view.showErrorMessage("Movie not in saved list: " + movieTitle);
}


     @Override
     public void handleResetMovieCollection() {
        model.reset();
        results = model.getMovies();
        System.out.println("Reset pressed, reloading movie collection with " + results.size() + " movie(s).");
        view.viewMovieCollection(results);
     }


     @Override
     public void handleSave(String fileType) {
        try {
            userList.save(fileType);
            view.showHelpMessage("🎉 Your movie list was saved as a ." + fileType + " file!");
        } catch (UnsupportedOperationException e) {
            view.showErrorMessage("Unsupported file type: " + fileType);
        } catch (Exception e) {
            view.showErrorMessage("Failed to save list: " + e.getMessage());
        }
     }

     public List<Movie> getResults() {
         return this.results;
     }

     @Override
    public void handleClearMovieList() {
        System.out.println("Clearing all movies from user list...");
        userList.clear();
    
        List<Movie> current = userList.getMovies();
        System.out.println("Cleared list has " + current.size() + " movie(s).");
    
        view.viewMovieList(current); 
        view.showHelpMessage("Movie list has been cleared.");
}

 }