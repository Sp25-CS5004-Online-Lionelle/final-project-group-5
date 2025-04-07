import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import student.model.MovieCollection;
import student.model.Movie;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import student.model.OMDBMovieData;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOMDBMovieData {

     @Test
     public void testGetApiUrl() {
         assertEquals("http://www.omdbapi.com/?t=moon&apikey=<api_ley>&", OMDBMovieData.getApiUrl("moon"));
     }

    @Test
    public void testGetMovieDetails() {

        ObjectMapper mapper = new ObjectMapper();
        Movie movie = null;
        Movie movieOne = null;

        try{
            movie = mapper.readValue(OMDBMovieData.getMovieDetails("Moon"), Movie.class);
            movieOne = mapper.readValue(OMDBMovieData.getMovieDetails("Dog Man"), Movie.class);

        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("Moon", movie.getTitle());
        assertEquals("Dog Man", movieOne.getTitle());
    }

}


