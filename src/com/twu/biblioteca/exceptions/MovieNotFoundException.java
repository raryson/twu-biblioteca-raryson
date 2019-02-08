package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.helpers.Messages;

public class MovieNotFoundException extends ProductNotFoundException {
    public MovieNotFoundException(){
        super(Messages.movieNotFound());
    }
}
