package com.twu.biblioteca;


import com.twu.biblioteca.helpers.BookStatus;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.services.BookService;
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
        assertEquals(expectedBooksMessage, Messages.booksInfosMessage(bookService.getAllBooks()));
    }

    @Test
    public void whenBookAreBeCheckouted() {
        final String bookNameAreBeChecked = "1984";
        ArrayList<Book> books = new ArrayList<Book>();
        Book book2 = new Book("Harry Potter", "J.K Rolling", "07/01/2006",
                                BookStatus.AVAILABLE);
        books.add(book2);

        Book book3 = new Book("Matrix", "Lana Wachowski and Lilly Wachowski", "07/01/2016",
                                BookStatus.AVAILABLE);
        books.add(book3);

        BookService bookService = new BookService();
        bookService.checkoutABook("1984");
        int counter = 0;
        for(Book resourcesBook: bookService.getAllBooks()){
            assertEquals(books.get(counter).getName(), resourcesBook.getName());
            counter++;
        }
    }
}
