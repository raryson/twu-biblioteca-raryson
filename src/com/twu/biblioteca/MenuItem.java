package com.twu.biblioteca;

public class MenuItem {
    private String name;
    private String option;

    public MenuItem(String name, String option) {
        this.name = name;
        this.option = option;
    }

    public String getName() {
        return name;
    }

    public String getOption() {
        return option;
    }
}
