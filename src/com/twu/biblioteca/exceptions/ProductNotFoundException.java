package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.helpers.Messages;

public class ProductNotFoundException extends Throwable {

    public ProductNotFoundException() {
        super(Messages.productNotExist());
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
