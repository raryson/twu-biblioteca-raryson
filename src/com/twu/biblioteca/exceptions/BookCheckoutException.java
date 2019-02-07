package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.helpers.Messages;

public class BookCheckoutException extends Throwable {

    public BookCheckoutException() {
        super(Messages.checkoutedABookFailed());
    }
}
