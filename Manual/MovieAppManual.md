# Movie App Program Manual – 5004 Final Project

### Requirements

Before you begin, please ensure you have the following:

- Java installed (version 8 or above)
- An IDE like IntelliJ or VSCode
- The source code of the project downloaded


### How to run the program

 From the IDE: 

1. Open the project folder in your IDE.
2. Locate the main class file [MovieApp.java](../src/main/java/student/MovieApp.java) 
3. Click the **Run** above `public static void main(String[] args)`.
4. The GUI should launch.


### Getting Started

The application's purpose is to allow the user to browse and filter a movie collection by title, year, genre, or description and then create their own movie list to save to a file. 
When the GUI lanches you will see:
    1. A searh bar and filter button at the top
    2. A large movie collection will display on the left
    3. An empty "My Movie List" panel on the right.
    4. Functional buttons along the top and bottom of the program frame. 


### Filtering Movies
The application allows the user to narrow down the movie collection for easier browsing by filtering.
    1. Type into the filter field to search by:
        * Title
        * Genre
        * Year
        * Description
    2. Use the dropdown menu to select the filter parameter and an operator:
        * == (equals)
        * != (does not equal)
        * >  (greater than)
        * <  (less than)
        * >= (greater than or equal to)
        * <= (less than or equal to)
        * ~=  (contains)
    3. Click the filter button to apply your filter

### Sorting Movies
The user may apply the sort function to the movie collection after it has been filtered. Note: The movie collection will automatically be sorted by title.
    1. Use the sort dropdown menu to select the sort parameter (title, year, or rating)
    2. Select Ascending or Decending order
    3. click the sort button

### Movie Collection (Left Panel)
    * The movie collection is displayed in the left panel
    * The movies are displayed as cards with the movie poster images and titles.
    * Click on the movie poster to display the full movie card.
    * Click the Add button on any card to move that movie to your personal movie list on the right. 

### My Movie List (Right Panel)
    * The panel of the right is your personalized movie list. 
    * Movies you add appear in the same card format as the movie collection.
    * Click the Remove button at any time to remove a movie from your movie list. 
    * You may add as many movies as you would like to My Movie List. As it grows, scroll through it. 
    * If you would like to start over, click clear list to remove all movies. 

### Individual Movie Cards
Every movie in the movie collection has a movie card with additional information outside of the filtering parameters. To access the movie card click on the movie poster in the movie collection or movie list. The movie card includes
    * Title
    * Genre: includes multiple genres
    * Rating: IMDB rating on a scale of 10
    * Cast: leading cast memebers
    * Description or plot

### Buttons Explained
    * Add All: Adds all visible movies in the movie collection to My Movie List. 
    * Reset Collection: Resets the filters and shows the full movie database again. 
    * Help: displays a detailed informational help message for users
    * Add: adds the single movie to My Movie List
    * Remove: removes a single movie from My Movie List
    * Clear List: cleans entire Movie List 
    * Save List: exports the users current Movie List to a JSON file.

### Saving your Movie List
The program allows your to save My Movie List as a local file once you are done browsing. 
    * Browse, Filter, Sort the movie collection.
    * Add Movies to My Movie List.
    * Click Save List to save your list to `userSavedLists.json`.

When you are done creating your Movie List, close the program. 
Thanks for running my program!
