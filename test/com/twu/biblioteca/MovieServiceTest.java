package com.twu.biblioteca;

import com.twu.biblioteca.infra.MovieData;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.services.MovieService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;


public class MovieServiceTest {

    @Test
    public void whenUserNeedToViewMoviesAssertToMoviestIsNotNull() {
        MovieData.generateMovies();
        MovieService movieService = new MovieService(MovieData.movies);
        final List<Movie> allMovies = movieService.getAllMovies();
        assertNotNull(allMovies);
    }

}
