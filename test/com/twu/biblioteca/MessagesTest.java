package com.twu.biblioteca;

import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.infra.BookData;
import com.twu.biblioteca.infra.MenuData;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.MenuService;
import org.junit.Test;


import static org.junit.Assert.*;

public class MessagesTest {

    @Test
    public void whenBooksAreShowedOnScreenAssertToEqualMockedListOfBooks() {
        final String expectedBooksMessage = "\tBook Name\tAuthor\tPublish Date\n" +
                                    "\t1984\tGeorge Orwell\t07/01/1996\n" +
                                    "\tHarry Potter\tJ.K Rolling\t07/01/2006\n" +
                                    "\tMatrix\tLana Wachowski and Lilly Wachowski\t07/01/2016\n";

        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        assertEquals(expectedBooksMessage, Messages.booksInfosMessage(bookService.getAllBooks()));
    }

    @Test
    public void whenMenuAreShowedOnScreenAssertToEqualToMockedMenuList() {
        final String expectedMenuMessage = "Please, select one of this options:\n\t0 - Exit\t1 - List All Books" +
                "\t2 - Checkout a Book\t3 - Checking a Book";
        MenuData.generateMenuList();
        MenuService menuService = new MenuService(MenuData.menuList);
        assertEquals(expectedMenuMessage, Messages.menuInfoMessage(menuService.getMenuList()));
    }

}
