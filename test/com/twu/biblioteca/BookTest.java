package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.BookAreCheckoutedException;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.helpers.BookStatus;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.services.BookService;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
        assertEquals(expectedBooksMessage, Messages.booksInfosMessage(bookService.getAllBooks()));
    }

    @Test
    public void whenBookAreBeCheckouted() {
        BookService bookService = new BookService();
        try {
            bookService.checkoutABook("1984");
        } catch (BookAreCheckoutedException e) {
            assertNotNull(e);
        } catch (BookNotFoundException e) {
            assertNotNull(e);
        }
        assertEquals(BookStatus.RENTED, bookService.checkBookStatus("1984"));
    }

    @Test
    public void whenABookSelectedNotExit() {
        BookService bookService = new BookService();
        try {
            bookService.checkoutABook("The ruleglessias Chronicals");
        } catch (BookNotFoundException ex) {
            assertNotNull(ex);
        } catch (BookAreCheckoutedException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenBookAreCheckoutedCheckedBook() {
        BookService bookService = new BookService();
        try {
            bookService.checkoutABook("1984");
            bookService.checkoutABook("1984");
        } catch (BookAreCheckoutedException ex){
            assertNotNull(ex);
        } catch (BookNotFoundException ex) {
            assertNull(ex);
        }

    }
}
