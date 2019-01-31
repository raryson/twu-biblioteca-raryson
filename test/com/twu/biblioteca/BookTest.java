package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookTest {

    @Test
    public void whenUserNeedToViewBooks() {
        BookService bookService = new BookService();
        final ArrayList<Book> allBooks = bookService.getAllBooks();
        assertNotNull(bookService.getAllBooks());
    }

    @Test
    public void whenUserNeedToViewAllBooksWithAuthorsAndPublishYearAndName() {
        BookService bookService = new BookService();
        for(Book book : bookService.getAllBooks()) {
            assertNotNull(book.getName());
            assertNotNull(book.getAuthor());
            assertNotNull(book.getPublishDate());
        }
    }

    @Test
    public void whenBooksAreShowedOnScreen() {
        final String expectedBooksMessage = "\tBook Name\tAuthor\tPublish Date\n" +
                                    "\t1984\tGeorge Orwell\t07/01/1996\n" +
                                    "\tHarry Potter\tJ.K Rolling\t07/01/2006\n" +
                                    "\tMatrix\tLana Wachowski and Lilly Wachowski\t07/01/2016\n";

        BookService bookService = new BookService();
        assertEquals(Messages.booksInfosMessage(bookService.getAllBooks()), expectedBooksMessage);
    }
}
