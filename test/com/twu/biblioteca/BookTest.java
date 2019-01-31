package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookTest {

    @Test
    public void WhenUserNeedToViewBooks() {
        BookService bookService = new BookService();
        final ArrayList<Book> allBooks = bookService.getAllBooks();
        assertNotNull(bookService.getAllBooks());
    }

    @Test
    public void WhenUserNeedToViewAllBooksWithAuthorsAndPublishYearAndName() {
        BookService bookService = new BookService();
        for(Book book : bookService.getAllBooks()) {
            assertNotNull(book.getName());
            assertNotNull(book.getAuthor());
            assertNotNull(book.getPublishDate());
        }

    }
}
