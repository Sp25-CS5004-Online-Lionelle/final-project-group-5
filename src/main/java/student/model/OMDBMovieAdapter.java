package student.model;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Arrays;
import java.util.List;

public class OMDBMovieAdapter {

    public static Movie convert(JsonNode omdbJson) {
        String title = getText(omdbJson, "Title");
        double rating = parseDouble(getText(omdbJson, "imdbRating"));
        int year = parseInt(getText(omdbJson, "Year"));
        String genre = getText(omdbJson, "Genre");
        String description = getText(omdbJson, "Plot");
        String imageUrl = getText(omdbJson, "Poster");
        List<String> cast = Arrays.asList(getText(omdbJson, "Actors").split("\\s*,\\s*"));

        return new Movie(title, rating, year, genre, cast, description, imageUrl);
    }

    private static String getText(JsonNode node, String field) {
        JsonNode val = node.get(field);
        return val != null ? val.asText() : "";
    }

    private static double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0.0;
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }
}
