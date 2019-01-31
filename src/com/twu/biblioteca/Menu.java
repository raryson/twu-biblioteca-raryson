package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {

    public Menu() {
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
                System.exit(12);
                break;
            }

            case MISSCLICK: {
                throw new ItemOnMenuNotFoundException();
            }
        }
    }

}
