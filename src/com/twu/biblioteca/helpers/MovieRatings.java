package com.twu.biblioteca.helpers;

import java.util.Arrays;
import java.util.Optional;

public enum MovieRatings {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    NORATING(666);

    private final int movieRatingValue;

     MovieRatings(int value) {
        this.movieRatingValue = value;
    }

    public static Optional<MovieRatings> valueOf(int value) {
        return Arrays.stream(values())
                .filter(menuType -> menuType.movieRatingValue == value)
                .findFirst();
    }
}
