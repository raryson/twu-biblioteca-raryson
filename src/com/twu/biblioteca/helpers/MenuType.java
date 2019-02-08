package com.twu.biblioteca.helpers;

import java.util.Arrays;
import java.util.Optional;

public enum MenuType {
    LISTOFBOOKS(1),
    EXIT(0),
    MISSCLICK(666),
    CHECKOUTABOOK(2),
    CHECKIGNABOOK(3),
    LISTOFMOVIES(4),
    CHECKINGAMOVIE(5),
    LIBRARIANINFOS(6);

    private final int menuValue;

     MenuType(int value) {
        this.menuValue = value;
    }

    public static Optional<MenuType> valueOf(int value) {
        return Arrays.stream(values())
                .filter(menuType -> menuType.menuValue == value)
                .findFirst();
    }

}
