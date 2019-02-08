package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;

import java.util.List;
import java.util.Optional;

public class MovieService {

    private List<Movie> movies;

    public MovieService(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie findMovieByName(String name) throws MovieNotFoundException {
        Optional<Movie> iteredMovie = movies
                .stream()
                .filter(movie -> movie.getName().equals(name))
                .findFirst();
        return iteredMovie.orElseThrow(() -> new MovieNotFoundException());
    }
}
