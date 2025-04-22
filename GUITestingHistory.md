# GUI Testing History

## GUI Introduction
Here you will find images and descriptions of our GUI testing process. For our view, we implmemted an interface IView. We included a class for the buttons on our GUI, the main JFrame, and 2 JPanel frames. The JPanel Frame on the left is the movie collection and on the right is the user movie list. Each jPanel uses the MovieGridDisplay to display the movie poster and titles in a grid format with a "Add" or "Remove" button beneath.

### Movie Display Card
We first started with creating the movie display card and testing the format. The display card is a pop up frame from the JPanel grid and includes detailed information about the movie such as title, year, genre, rating, cast, and description. Below is an image of the test file and the pop up. <br><br>
![Movie Display Test File](images/testmoviedisplay.jpg)
![Movie Display Card](images/moviedisplaycard.jpg)

### Movie Card Panel
Next we created and tested the Movie Card Panel which would be how the movies would display to the user next to each other in a grid format with the movie poster and name. If a user clicks the poster the Movie Display Card pops up. <br><br>
![Movie Card Panel Test File](images/testmoviecardpanel.jpg)
![Movie Card Panel](images/moviecardpanel.jpg)

### Initial JFrame and Buttons
Then we created the JFrame to hold the buttons and eventually the other JPanels. The first image is when we tested the JFrame with buttons at the top and aligned to the left. <br><br>
![JFrame 1](images/jframe_1.jpg) <br><br>
Next we worked on aligning the buttons at the top in 3 rows and centering them. We also tested adding a welcome message to the JFrame which eventually became a popup message after we added the JPanels. <br><br>
![JFrame 2](images/jframe_2.jpg) <br>
In the JFrame, we added the first JPanel and we tested it with the file below which included 4 sample movies. <br><br>
![JFrame Test File](images/testjframeview.jpg)<br>
At first we intended to have a the user Movie List to be a pop up, but decided to do a split JPanel with the Movie Collection on the left and the Movie List on the right. The image below shows our group testing the view of the split panel and making sure the movie cards include the add or remove buttons. <br><br>
![JFrame 3](images/jframe_3.jpg)<br>
Next we implmented the clear list and save to file buttons on the GUI. We tested if they were visible when run. <br><br>
![JFrame 4](images/jframe_4.jpg)<br>

### Connecting the controller and continued testing
After having a basic GUI compiled, it was time to connect the controller and use a smaller list of movies to test the application. The image below shows us testing the filter fuction and sorting the movie collection. <br><br>
![JFrame 5](images/jframe_5.jpg)<br>
We created error messages to direct the user and tested they popped up at the appropriate times. Such as making sure ascending or descending is selected. <br>
![JFrame 6](images/jframe_6.jpg)<br>
Or that the Movie collection is filtered before sorted. <br>
![JFrame 7](images/jframe_7.jpg)<br>
This image shows us testing the filter and add button for multiple movies. <br>
![JFrame 9](images/jframe_9.jpg)<br>
Then we checked the help message pop up to guide users through the experience of using our application. This message was later updated to be more robust and informative for the user. <br>
![JFrame 10](images/jframe_10.jpg)<br>

### Final Testing with full Movie Collection
Once we connected the controller and fixed all bugs, we connected the GUI to the full Movie Collection for testing. We also implemented a logical order for the Movie Collection by title. <br><br>
Here is an image of the GUI with the full movie collection connected. It loaded correctly <br>

![JFrame 11](images/jframe_11.jpg)<br>
Then with the full movie collection we did a set of testing, for example we filtered for movies created `<` the year 1979 and manually checked if Alien was included (created in 1979) <br>
![JFrame 12](images/jframe_12.jpg)<br>
Then we tested using the operator `<=` 1979 and alien was in the movie collection. <br>
![JFrame 13](images/jframe_13.jpg)<br>
Then we tested the sort function with the entire movie collection after the previous filter. We manually checked the movie card pop up to check dates.
![JFrame 14](images/jframe_14.jpg)<br>
Lastly here is an example image of testing the add and remove buttons as we created a movie list using the whole collection and saving it to the file. <br>
![JFrame 15](images/jframe_15.jpg)<br>
