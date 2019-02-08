package com.twu.biblioteca.infra;

import com.twu.biblioteca.helpers.MovieRatings;
import com.twu.biblioteca.helpers.ProductStatus;
import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieData {

    public static List<Movie> movies;

    public static void generateMovies() {
        movies = new ArrayList<>();
        Movie movie1 = new Movie("Matrix", "2000",
                "Lana Wachowski and Lilly Wachowski", MovieRatings.TEN, ProductStatus.AVAILABLE);
        movies.add(movie1);

        Movie movie2 = new Movie("Narnia", "2006", "C. S. Lewis", MovieRatings.SIX,
                ProductStatus.AVAILABLE);
        movies.add(movie2);

        Movie movie3 = new Movie("9 Miles", "2010", "Eminem", MovieRatings.NORATING,
                ProductStatus.RENTED);
        movies.add(movie3);
    }
}
