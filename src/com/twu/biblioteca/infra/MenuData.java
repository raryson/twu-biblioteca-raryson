package com.twu.biblioteca.infra;

import com.twu.biblioteca.helpers.MenuType;
import com.twu.biblioteca.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuData {
    public static List<MenuItem> menuList;

    public static void generateMenuList() {
        menuList = new ArrayList<MenuItem>();
        MenuItem exitItem = new MenuItem("Exit", MenuType.EXIT, 0);
        MenuItem listOfBookItem = new MenuItem("List All Books", MenuType.LISTOFBOOKS, 1);
        MenuItem checkoutABookItem = new MenuItem("Checkout a Book", MenuType.CHECKOUTABOOK, 2);
        MenuItem checkingABook = new MenuItem("Checking a Book", MenuType.CHECKIGNABOOK, 3);
        MenuItem listOfMovieItem = new MenuItem("List All Movies", MenuType.LISTOFMOVIES, 4);
        MenuItem checkinAMovie = new MenuItem("Checkin a Movie", MenuType.CHECKINGAMOVIE, 5);
        MenuItem librarianInfos = new MenuItem("Librarian Infos", MenuType.LIBRARIANINFOS, 6);
        MenuItem userInfos = new MenuItem("User Infos", MenuType.USERINFOS, 7);

        menuList.add(exitItem);
        menuList.add(listOfBookItem);
        menuList.add(checkoutABookItem);
        menuList.add(checkingABook);
        menuList.add(listOfMovieItem);
        menuList.add(checkinAMovie);
        menuList.add(librarianInfos);
        menuList.add(userInfos);
    }
}
