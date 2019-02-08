package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.MenuType;

public class MenuItem {
    private String name;
    private MenuType option;
    private int number;

    public MenuItem(String name, MenuType option, int number) {
        this.name = name;
        this.option = option;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public MenuType getOption() {
        return option;
    }

    public int getNumber(){
        return this.number;
    }
}
