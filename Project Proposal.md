The proposal does not have to be a formal presentation. Though if that helps the team keep their thoughts organized, that is fine. Every team member should be present to talk about the proposal. The proposal should include the following:

1. What are you building? 
    We are building a movie application that fetches movie data from an open API (TBD) and allows the user to search, filter, sort movies through a GUI. We are hoping to build userprofile and storage features so the user cannot only search the database, but also add their own ratings and reviews which can be accessed across different sessions. 

2. What are the initial features for the application?
   * GUI
   * a collection of movies 
   * build a list of movies from the larger collection
   * save the list to a file (CSV, JSON, XML)

3. What are the minimum additional features you plan to implement?
    * use an online movie API such as TMBD or OMDB
    * search for specific moviees
    * sort movies in ascending or decending order
    * filter movie list by name, rating, year, genre

4. What are your stretch goals (features beyond the minimum)?
   * include images of movie posters upon search
   * allow a user to provide personal movie ratings and reviews that remain persistent across sessions
   * filter items by keywords
  
   
5. Go over your initial design.
    Special emphasis should be placed on how you plan to break it up
    MVC, presenter, file management, different input validation, testing, documentation, etc.

    What should we make interfaces for? Ideas...
    * MovieDataFetch (this one makes sense to me since we could use various APIs)


    Main Entry: MovieApp

    Model: files to be put in the model package
    * Movie, a class to hold movie object details (title, average rating, year, genre, cast, description, and image?) include getter and setter methods
    * IMovieCollection interface that sets up the filter and sorts
    * MovieCollection class, manages the entire collection of movie objects for adding, removing, filtering, sorting etc
    * IMovieList, interface for MovieList
    * MovieList class, the list of Movie Objects
    * Operations enum for operations that remain constant for filtering/sorting
    * MovieFilter class, a class with various methods to filter movie data such as filterByGenre, filterByYear, filterByKeyword etc
    * MovieSort, a class to sort movie data ascending or ascending. sortByYear, sortByRating etc
    * MovieDataFetch interface, an interface to fetch the data from various APIs (TMBD, OMDB, or another)
    * OMDBMovieData, a class that fetches movie data from the specfic API we decide to use
    * MovieStorage, a class to load/save the MovieList to multiple file types
    * UserProfile, a class to create userprofile for ratings and short reviews
    * UserProfileStorage, a class to save the user profile to a file and retreive it between sessions

    Controller: files to be put in the controller package 
    * MovieController, connects the model with the view, will have start() to make view visible

    View: files to be put in the view package
    * MovieView, the class for the graphical user interface using JFrame. Show's search, sort, and filter results and user profile. 
    * ConsoleApp, a way to use the command line as well as the GUI?
  
    Testing: testing files
    * TestMovie 
    * TestMovieCollection
    * TestMovieFilter
    * TestMovieSort
    * TestOMDBMovieDataFetch
    * TestMovieStorage
    * TestUserProfile
    * TestUserProfileStorage
* 
1. How do you plan to break up the work?
    We plan to break up the work by using a github projects template to assign tasks to different group members. 
    We will initially divide the tasks evenly by class and testfile.
   
2. What is your teams timeline and major check-in points?
   major check-in points will be weekly check ins on Tuesday during our meeting time: 3/25, 4/1, 4/8, 4/15. 
   * By 3/25: Proposal and Initial Design Complete
       * finalize features
       * assign tasks
       * decide on API
   * By 4/1: TDD-- Models, API, + storage
       * implmenent Movie and MovieCollection
       * build MovieDataFetch with testing
       * build MovieStorage with testing
       * build userprofile with testing
   * By 4/8: GUI and Controlller
       * build MovieView GUI
       * implement controller, start, search, filter, sort
       * connect GUI to model 
   * By 4/15: Final Testing + Debugging
       * testing with API calls
       * testing with search, sort, filter
       * testing file storage
       * testing gui 
   * By 4/18: Project Turned in! 
       * double check DRY code / java doc comments
       * demo with Albert or TA
