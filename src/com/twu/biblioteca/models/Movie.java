package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.MovieRatings;
import com.twu.biblioteca.helpers.ProductStatus;

public class Movie extends Product {

    private String name;
    private String year;
    private String director;
    private MovieRatings rating;

    public Movie(String name, String year, String director, MovieRatings rating, ProductStatus status) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.setStatus(status);
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public MovieRatings getRating() {
        return rating;
    }
}
