The proposal does not have to be a formal presentation. Though if that helps the team keep their thoughts organized, that is fine. Every team member should be present to talk about the proposal. The proposal should include the following:

1. What are you building?
   We are building a movie application that fetches movie data from an open API (TBD) and allows the user to search, filter, sort movies through a GUI. We are hoping to build userprofile and storage features so the user cannot only search the database, but also add their own ratings and reviews which can be accessed across different sessions.

2. What are the initial features for the application?

   - GUI

     - Search movies component
       - Includes input field and search button
       - Search by keywords (movie name, genre, etc.)
       - After enter the search button, the UI will display a few(number to be TBD) match moives
       - For each displayed movie, there should be a `button` to save the movie to the `saved movie list`
     - Display saved movies component
       - a `Saved List` movie button
       - after clicking the saved list button, the UI will render the list of saved movies
     - Movie component (the details each movie should display on the UI)
       - Movie name
       - Release dates
       - Rating
       - genre
     - Will also include some buttons/dropdowns to sort the movies by movies, ratings, etc.

   - a collection of movies
   - build a list of movies from the larger collection
   - save the list to a file (CSV, JSON, XML)

3. What are the minimum additional features you plan to implement?

   - use an online movie API such as TMBD or OMDB
   - search for specific moviees
   - sort movies in ascending or decending order
     - Such as sort the movies in the saved list
   - filter movie list by name, rating, year, genre

4. What are your stretch goals (features beyond the minimum)?

   - include images of movie posters upon search
   - allow a user to provide personal movie ratings and reviews that remain persistent across sessions
   - filter items by keywords
   - delete a movie from the saved movie list

5. Go over your initial design.
   Special emphasis should be placed on how you plan to break it up
   MVC, presenter, file management, different input validation, testing, documentation, etc.

   What should we make interfaces for? Ideas...

   - MovieDataFetch (this one makes sense to me since we could use various APIs)

   Main Entry: MovieApp

   Model: files to be put in the model package

   - Movie, a class to hold movie object details (title, average rating, year, genre, cast, description, and image?) include getter and setter methods
   - MovieCollection class, manages the entire collection with methods for adding and removing from list
   - MovieFilter class, a class with various methods to filter movie data such as filterByGenre, filterByYear, filterByKeyword etc
   - MovieSort, a class to sort movie data ascending or ascending. sortByYear, sortByRating etc
   - MovieDataFetch interface, an interface to fetch the data from various APIs (TMBD, OMDB, or another)
   - OMDBMovieData, a class that fetches movie data from the specfic API we decide to use
   - MovieStorage, a class to load/save the list to multiple file types
   - UserProfile, a class to create userprofile
   - UserProfileStorage, a class to save the user profile to a file
   - InputReader, a class with method to read saved moives from local xml/csv/json files
   - MovieWritter, a class with methods to write movies to local xml/csv/json files

   Controller: files to be put in the controller package

   - MovieController, connects the model with the view, will have start() to make view visible
   - IController interface

   View: files to be put in the view package

   - JFrameView, a class serves as the main window for this application. This is the class for the graphical user interface using JFrame. Show's search, sort, and filter results and user profile.
   - MovieDisplay, a class to display the list of movies, including movie details
   - ButtonCommands, a class to define the button listener, such as sorting, searching by keywords, list all saved movies, etc

   Testing: testing files

   - TestMovie
   - TestMovieCollection
   - TestMovieFilter
   - TestMovieSort
   - TestOMDBMovieDataFetch
   - TestMovieStorage
   - TestUserProfile
   - TestUserProfileStorage
   - TestInputReader
   - TestMovieWritter

-

1. How do you plan to break up the work?
   We plan to break up the work by using a github projects template to assign tasks to different group members.
   We will initially divide the tasks evenly by class and testfile.

2. What is your teams timeline and major check-in points?
   major check-in points will be weekly check ins on Tuesday during our meeting time: 3/25, 4/1, 4/8, 4/15.
   - By 3/25: Proposal and Initial Design Complete
     - finalize features
     - assign tasks
     - decide on API
   - By 4/1: TDD-- Models, API, + storage
     - implmenent Movie and MovieCollection
     - build MovieDataFetch with testing
     - build MovieStorage with testing
     - build userprofile with testing
   - By 4/8: GUI and Controlller
     - build MovieView GUI
     - implement controller, start, search, filter, sort
     - connect GUI to model
   - By 4/15: Final Testing + Debugging
     - testing with API calls
     - testing with search, sort, filter
     - testing file storage
     - testing gui
   - By 4/18: Project Turned in!
     - double check DRY code / java doc comments
     - demo with Albert or TA
