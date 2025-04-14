import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import student.controller.MovieController;
import student.model.*;
import student.view.IView;
import student.view.JFrameView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMovieController {

    static IMovieCollection model = new MovieCollection();
    static IMovieList userList = new MovieList();
    static IView view = new JFrameView(model.getMovies());
    static MovieController controller;



    @BeforeAll
    public static void setup(){
        controller = new MovieController(model, userList, view);
    }

    @Test
    public void testHandleSearch(){
        controller.handleSearch("Minions", Operations.CONTAINS, FilterType.TITLE);
        assertEquals("Minions", controller.getResults().get(0).getTitle());
        controller.handleSearch("Dog Man",Operations.CONTAINS, FilterType.TITLE);
        assertEquals(1, controller.getResults().size());

    }

    @Test
    public void testHandleSort(){
        controller.handleSearch("M", Operations.CONTAINS, FilterType.TITLE);
        controller.handleSort(FilterType.YEAR, true);
        assertEquals("Moon", controller.getResults().get(0).getTitle());
        controller.handleSort(FilterType.YEAR, false);
        assertEquals("Dog Man", controller.getResults().get(0).getTitle());

    }
}
