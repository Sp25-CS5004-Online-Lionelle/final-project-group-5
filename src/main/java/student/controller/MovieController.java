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
            } else if (view.getSelectedSort().toUpperCase().equalsIgnoreCase("RATING")){
                handleSort(
                        FilterType.RATING,
                        view.getSort()
                );
            }

        });

        view.addAddMovieListener(e -> handleAddMovie(view.getSearchQuery()));
        view.addRemoveMovieListener(e -> handleResetMovieCollection());
        view.setRemoveAction(this::handleRemoveMovie);


        view.addAddAllListener(e -> {
            List<Movie> toAdd = results.isEmpty() ? model.getMovies() : results;
            System.out.println("Before addAll, userList has: " + userList.getMovieTitles());
            userList.addAll(toAdd);
            System.out.println("After addAll, userList has: " + userList.getMovieTitles());
            view.viewMovieList(userList.getMovies());
        });

        view.addSaveListener(e -> handleSave("json"));
        view.addClearListener(e -> handleClearList());
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
         for (Movie movie : model.getMovies()) {
             if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                 userList.add(movie);
                 view.viewMovieList(userList.getMovies());
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
                 view.viewMovieList(userList.getMovies());
                 return;
             }
         }
         view.showErrorMessage("Movie not in saved list: " + movieTitle);
     }

     public void handleRemoveMovie(Movie movie) {
         userList.remove(movie);
         view.viewMovieList(userList.getMovies());
     }

     @Override
     public void handleResetMovieCollection() {
         results = model.getMovies();
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

     public void handleClearList() {
         userList.clear();
         view.viewMovieList(userList.getMovies());
     }

     public List<Movie> getResults() {
         return this.results;
     }
 }