package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.helpers.Messages;

public class BookCheckinException extends Throwable {

    public BookCheckinException(){
        super(Messages.checkinABookFailed());
    }
}
