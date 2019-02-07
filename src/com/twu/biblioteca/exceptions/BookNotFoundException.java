package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.helpers.Messages;

public class BookNotFoundException extends Throwable {

    public BookNotFoundException () {
        super(Messages.bookNotExist());
    }
}
