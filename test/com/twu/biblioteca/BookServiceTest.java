package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.BookCheckinException;
import com.twu.biblioteca.exceptions.BookCheckoutException;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.infra.BookData;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.services.BookService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void whenUserNeedToViewBooksAssertToBookListIsNotNull() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        final List<Book> allBooks = bookService.getAllBooks();
        assertNotNull(allBooks);
    }

    @Test
    public void whenUserNeedToViewAllBooksWithAuthorsAssertAuthorIsNotNull() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        String authorName = bookService.getAllBooks().get(1).getAuthor();
        assertNotNull(authorName);
    }

    @Test
    public void whenUserNeedToViewAllBooksWithAuthorsAssertBookNameIsNotNull() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        String bookName = bookService.getAllBooks().get(1).getName();
        assertNotNull(bookName);
    }

    @Test
    public void whenUserNeedToViewAllBooksWithAuthorsAssertPublishDateIsNotNull() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        String publishDate = bookService.getAllBooks().get(1).getPublishDate();
        assertNotNull(publishDate);
    }



    @Test
    public void whenABookSelectedNotExistInCheckoutAssertToThrowAExceptionBookNotFound() {
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
    public void whenABookSelectedNotExistInCheckinAsssertToThrowAExceptionBookNotFound() {
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
    public void whenBookAreCheckouinedCheckedBookAssertToThrowAExceptionBookCheckingException() {
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
    public void whenBookAreCheckoutedCheckedBookAssertToThrowAExceptionBookCheckoutedException() {
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
