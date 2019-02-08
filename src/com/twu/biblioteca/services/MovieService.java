package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.MovieNotFoundException;
import com.twu.biblioteca.helpers.ProductStatus;
import com.twu.biblioteca.models.Movie;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieService {

    private List<Movie> movies;

    public MovieService(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getAllMovies() {
        List<Movie> filteredMovies = movies.stream()
                .filter(p -> p.getStatus()
                        .equals(ProductStatus.AVAILABLE))
                .collect(Collectors.toList());
        return filteredMovies;
    }

    public Movie findMovieByName(String name) throws MovieNotFoundException {
        Optional<Movie> iteredMovie = movies
                .stream()
                .filter(movie -> movie.getName().equals(name))
                .findFirst();
        return iteredMovie.orElseThrow(() -> new MovieNotFoundException());
    }
}
