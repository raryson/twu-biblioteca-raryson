package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.MenuTypes;

public class MenuItem {
    private String name;
    private MenuTypes option;
    private int number;

    public MenuItem(String name, MenuTypes option, int number) {
        this.name = name;
        this.option = option;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public MenuTypes getOption() {
        return option;
    }

    public int getNumber(){
        return this.number;
    }
}
