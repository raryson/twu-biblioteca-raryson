package com.twu.biblioteca.infra;

import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuData {
    public static List<MenuItem> menuList;

    public static void generateMenuList() {
        menuList = new ArrayList<MenuItem>();
        MenuItem exitItem = new MenuItem("Exit", MenuTypes.EXIT, 0);
        MenuItem listOfBookItem = new MenuItem("List All Books", MenuTypes.LISTOFBOOKS, 1);
        MenuItem checkoutABookItem = new MenuItem("Checkout a Book", MenuTypes.CHECKOUTABOOK, 2);
        MenuItem checkingABook = new MenuItem("Checking a Book", MenuTypes.CHECKIGNABOOK, 3);

        menuList.add(exitItem);
        menuList.add(listOfBookItem);
        menuList.add(checkoutABookItem);
        menuList.add(checkingABook);
    }
}
