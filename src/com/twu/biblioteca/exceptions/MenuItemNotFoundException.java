package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.helpers.Messages;

public class MenuItemNotFoundException extends Throwable {

    public MenuItemNotFoundException() {
        super(Messages.triggeredInvalidMenu());
    }
}
