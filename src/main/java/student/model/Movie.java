package student.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Movie class that represents a movie object.
 */
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown properties
@JsonPropertyOrder({"title", "year", "averageRating", "cast", "genre", "description", "imageUrl"}) // Order of properties in JSON
public class Movie {
    /**
     * title: Title of the movie
     */
    private String title;
    /**
     * averageRating: Average rating of the movie
     */
    private double averageRating;
    /**
     * year: Year of release
     */
    private int year;
    /**
     * genre: Genre of the movie
     */
    private String genre;
    /**
     * cast: List of actors in the movie -- change once we know from api what the cast looks like
     */
    private List<String> cast;
    /**
     * description: Description of the movie
     */
    private String description;
    /**
     * imageUrl: URL of the movie poster -- or from api?
     */
    private String imageUrl;

    /**
     * Constructor initializes the movie object with the given parameters.
     * @param title Title of the movie
     * @param averageRating Average rating of the movie
     * @param year Year of release
     * @param genre Genre of the movie
     * @param cast List of actors in the movie
     * @param description Description of the movie
     * @param imageUrl URL of the movie poster
     */
    public Movie(String title, double averageRating, int year, String genre,
                 List<String> cast, String description, String imageUrl) {
        this.title = title;
        this.averageRating = averageRating;
        this.year = year;
        this.genre = genre;
        this.cast = cast;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // getter methods

    /**
     * Getter method for the title of the movie.
     * @return Title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for the average rating of the movie.
     * @return Average rating of the movie
     */
    public double getAverageRating() {
        return averageRating;
    }

    /**
     * Getter method for the year of release of the movie.
     * @return Year of release of the movie
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter method for the genre of the movie.
     * @return Genre of the movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Getter method for the list of actors in the movie.
     * @return List of actors in the movie
     */
    public List<String> getCast() {
        return cast;
    }

    /**
     * Getter method for the description of the movie.
     * @return Description of the movie
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter method for the URL of the movie poster.
     * @return URL of the movie poster
     */
    public String getImageUrl() {
        return imageUrl;
    }

    // setter methods

    /**
     * Setter method for the title of the movie.
     * @param title Title of the movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter method for the average rating of the movie.
     * @param averageRating Average rating of the movie
     */
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    /**
     * Setter method for the year of release of the movie.
     * @param year Year of release of the movie
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Setter method for the genre of the movie.
     * @param genre Genre of the movie
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Setter method for the list of actors in the movie.
     * @param cast List of actors in the movie
     */
    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    /**
     * Setter method for the description of the movie.
     * @param description Description of the movie
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter method for the URL of the movie poster.
     * @param imageUrl URL of the movie poster
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Checks if two movie objects are equal, based on their title and year. 
     * @param o Object to compare
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return year == movie.year && title.equalsIgnoreCase(movie.title);
    }

    /**
     * Generates a hash code for the movie object based on its title and year.
     * @return Hash code of the movie object
     */
    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), year);
    }

    /**
     * Returns a string representation of the movie object.
     * @return String representation of the movie object
     */
    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}
