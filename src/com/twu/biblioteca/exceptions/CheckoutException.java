package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.helpers.Messages;

public class CheckoutException extends Throwable {

    public CheckoutException() {
        super(Messages.checkoutedFailed());
    }
}
