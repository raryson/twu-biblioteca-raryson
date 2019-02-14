package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.*;
import com.twu.biblioteca.infra.AuthData;
import com.twu.biblioteca.infra.BookData;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.services.AuthService;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.ProductService;
import org.junit.Test;

import javax.security.auth.login.LoginException;
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
    public void whenABookSearchedNotExist() {
        BookData.generateLibrary();
        BookService bookService = new BookService(BookData.books);
        try {
            bookService.findABookByName("The ruleglessias Chronicals");
        } catch (BookNotFoundException ex) {
            assertNotNull(ex);
        }
    }

    @Test
    public void whenBookAreCheckouinedCheckedBookAssertToThrowAExceptionBookCheckingException() {
        BookData.generateLibrary();
        ProductService productService = new ProductService();
        BookService bookService = new BookService(BookData.books);
        try {
            AuthData.generateUsers();
            AuthService authService = new AuthService(AuthData.users);
            User user = authService.login("111-1111", "123");
            Book book = bookService.findABookByName("1984");
            productService.checkout(book, user);
            productService.checkout(book, user);
        } catch (BookNotFoundException ex) {
            assertNull(ex);
        } catch (UserNotFoundException e) {
            assertNull(e);
        } catch (LoginException e) {
            assertNull(e);
        } catch (ProductNotFoundException e) {
            assertNull(e);
        } catch (BookCheckoutException e) {
            assertNotNull(e);
        } catch (CheckoutException e) {
            assertNull(e);
        }
    }

    @Test
    public void whenBookAreCheckoutedCheckedBookAssertToThrowAExceptionBookCheckoutedException() {
        BookData.generateLibrary();
        ProductService productService = new ProductService();
        BookService bookService = new BookService(BookData.books);
        try {
            AuthData.generateUsers();
            AuthService authService = new AuthService(AuthData.users);
            User user = authService.login("111-1111", "123");
            Book book = bookService.findABookByName("1984");
            productService.checking(book, user);
            productService.checking(book, user);
        } catch (BookNotFoundException ex) {
            assertNull(ex);
        } catch (UserNotFoundException e) {
            assertNull(e);
        } catch (LoginException e) {
            assertNull(e);
        } catch (BookCheckinException e) {
            assertNotNull(e);
        }
    }

}
