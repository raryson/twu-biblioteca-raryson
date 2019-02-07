package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.BookCheckinException;
import com.twu.biblioteca.exceptions.BookCheckoutException;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.helpers.BookStatus;
import com.twu.biblioteca.infra.BookData;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.services.BookService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void whenUserNeedToViewBooks() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        final List<Book> allBooks = bookService.getAllBooks();
        assertNotNull(allBooks);
    }

    @Test
    public void whenUserNeedToViewAllBooksWithAuthorsAndPublishYearAndName() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        for(Book book : bookService.getAllBooks()) {
            String bookName = book.getName();
            String bookAuthor = book.getAuthor();
            String bookPublishDate = book.getPublishDate();

            assertNotNull(bookName);
            assertNotNull(bookAuthor);
            assertNotNull(bookPublishDate);
        }
    }


    @Test
    public void whenBookAreBeCheckouted() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        try {
            bookService.checkoutABook("1984");
        } catch (BookCheckoutException e) {
            assertNotNull(e);
        } catch (BookNotFoundException e) {
            assertNotNull(e);
        }

        BookStatus bookStatus = bookService.checkBookStatus("1984");
        assertEquals(BookStatus.RENTED, bookStatus);
    }

    @Test
    public void whenABookSelectedNotExistInCheckout() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        try {
            bookService.checkoutABook("The ruleglessias Chronicals");
        } catch (BookNotFoundException ex) {
            assertNotNull(ex);
        } catch (BookCheckoutException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenABookSelectedNotExistInCheckin() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        try {
            bookService.checkingABook("The ruleglessias Chronicals");
        } catch (BookNotFoundException ex) {
            assertNotNull(ex);
        } catch (BookCheckinException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenBookAreCheckined() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        try {
            bookService.checkingABook("The Battle of the Apocalipse");
            BookStatus bookStatus = bookService.checkBookStatus("The Battle of the Apocalipse");
            assertEquals(BookStatus.AVAILABLE, bookStatus);
        } catch (BookCheckinException ex){
            assertNull(ex);
        } catch (BookNotFoundException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenBookAreCheckouinedCheckedBook() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        try {
            bookService.checkingABook("1984");
            bookService.checkingABook("1984");
        } catch (BookCheckinException ex){
            assertNotNull(ex);
        } catch (BookNotFoundException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenBookAreCheckoutedCheckedBook() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        try {
            bookService.checkoutABook("1984");
            bookService.checkoutABook("1984");
        } catch (BookCheckoutException ex){
            assertNotNull(ex);
        } catch (BookNotFoundException ex) {
            assertNull(ex);
        }
    }
}
