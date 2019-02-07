package com.twu.biblioteca.helpers;

import java.util.Arrays;
import java.util.Optional;

public enum MenuTypes {
    LISTOFBOOKS(1),
    EXIT(0),
    MISSCLICK(666),
    CHECKOUTABOOK(2),
    CHECKIGNABOOK(3),
    LISTOFMOVIES(4);

    private final int menuValue;

     MenuTypes(int value) {
        this.menuValue = value;
    }

    public static Optional<MenuTypes> valueOf(int value) {
        return Arrays.stream(values())
                .filter(menuType -> menuType.menuValue == value)
                .findFirst();
    }
}
