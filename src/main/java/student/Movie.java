package student;

import java.util.Objects;
import java.util.List;

/**
 * Movie class that represents a movie object.
 */
public class Movie {
    private String title;
    private double averageRating;
    private int year;
    private String genre;
    private List<String> cast;
    private String description;
    private String imageUrl;

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

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Equality based on title and year
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return year == movie.year && title.equalsIgnoreCase(movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), year);
    }

    @Override
    public String toString() {
        return title + " (" + year + ")";
    }
}
