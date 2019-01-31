package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.ItemOnMenuNotFoundException;
import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.models.MenuItem;

import java.util.ArrayList;

public class MenuService {

    public MenuService() {
        MenuItem exitItem = new MenuItem("Exit", MenuTypes.EXIT, 0);
        MenuItem listOfBookItem = new MenuItem("List All Books", MenuTypes.LISTOFBOOKS, 1);
        menuList.add(exitItem);
        menuList.add(listOfBookItem);
    }

    private ArrayList<MenuItem> menuList = new ArrayList();

    public ArrayList<MenuItem> getMenuList() {
        return this.menuList;
    }

    public void triggerActionItem(MenuTypes triggeredOption) throws ItemOnMenuNotFoundException {
        switch(triggeredOption) {
            case LISTOFBOOKS: {
                BookService bookService = new BookService();
                System.out.println(Messages.booksInfosMessage(bookService.getAllBooks()));
                break;
            }

            case EXIT: {
                System.out.println(Messages.triggeredExit());
                System.exit(0);
                break;
            }

            case MISSCLICK: {
                throw new ItemOnMenuNotFoundException();
            }
        }
    }

}
