package com.twu.biblioteca.services;

import com.twu.biblioteca.models.Movie;

import java.util.List;

public class MovieService {

    private List<Movie> movies;

    public MovieService(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }
}
