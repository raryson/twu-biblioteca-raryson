package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.helpers.Messages;

public class UserNotFoundException extends Throwable {

    public UserNotFoundException() {
        super(Messages.userNotexist());
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
