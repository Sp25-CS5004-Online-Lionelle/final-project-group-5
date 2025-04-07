package student.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;
import java.util.List;

/**
 * Movie class that represents a movie object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"Title", "imdbRating", "Year", "Genre", "Actors", "Plot", "Poster"})
public class Movie {

    /**
     * title: Title of the movie
     */
    @JsonProperty("Title")
    private String title;

    /**
     * averageRating: Average rating of the movie
     */
    @JsonProperty("imdbRating")
    private double averageRating;

    /**
     * year: Year of release
     */
    @JsonProperty("Year")
    private int year;

    /**
     * genre: Genre of the movie
     */
    @JsonProperty("Genre")
    @JsonDeserialize(using = ListOfStringDeserializer.class)
    @JsonSerialize(using = ListOfStringSerializer.class)
    private List<String> genre;

    /**
     * cast: List of actors in the movie -- change once we know from api what the cast looks like
     */
    @JsonProperty("Actors")
    @JsonDeserialize(using = ListOfStringDeserializer.class)
    @JsonSerialize(using = ListOfStringSerializer.class)
    private List<String> cast;

    /**
     * description: Description of the movie
     */
    @JsonProperty("Plot")
    private String description;

    /**
     * imageUrl: URL of the movie poster -- or from api?
     */
    @JsonProperty("Poster")
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
    @JsonCreator
    public Movie(@JsonProperty("Title") String title, @JsonProperty("imdbRating") double averageRating,
                 @JsonProperty("Year") int year, @JsonProperty("Genre") List<String> genre,
                 @JsonProperty("Actors") List<String> cast, @JsonProperty("Plot") String description,
                 @JsonProperty("Poster") String imageUrl) {
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
    public List<String> getGenre() {
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
    public void setGenre(List<String> genre) {
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
