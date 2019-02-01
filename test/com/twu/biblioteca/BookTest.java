package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.BookAreCheckinedException;
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
                                    "\tMatrix\tLana Wachowski and Lilly Wachowski\t07/01/2016\n" +
                                    "\tThe Battle of the Apocalipse\tEduardo Sphor\t07/01/2026\n";

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
    public void whenABookSelectedNotExistInCheckout() {
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
    public void whenABookSelectedNotExistInCheckin() {
        BookService bookService = new BookService();
        try {
            bookService.checkingABook("The ruleglessias Chronicals");
        } catch (BookNotFoundException ex) {
            assertNotNull(ex);
        } catch (BookAreCheckinedException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenBookAreCheckined() {
        BookService bookService = new BookService();
        try {
            bookService.checkingABook("The Battle of the Apocalipse");
            assertEquals(BookStatus.AVAILABLE, bookService.checkBookStatus("The Battle of the Apocalipse"));
        } catch (BookAreCheckinedException ex){
            assertNull(ex);
        } catch (BookNotFoundException ex) {
            assertNull(ex);
        }
    }

    @Test
    public void whenBookAreCheckouinedCheckedBook() {
        BookService bookService = new BookService();
        try {
            bookService.checkingABook("1984");
            bookService.checkingABook("1984");
        } catch (BookAreCheckinedException ex){
            assertNotNull(ex);
        } catch (BookNotFoundException ex) {
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

    @Test
    public void whenABookAreCheckoutedMessage() {
        final String expectedResult = "Thank you! Enjoy the book";
        assertEquals(expectedResult, Messages.checkoutedABookSucesseful());
    }

    @Test
    public void whenABookCannotBeCheckoutMessage() {
        final String expectedResult = "Sorry, that book is not available";
        assertEquals(expectedResult, Messages.checkoutedABookFailed());
    }

    @Test
    public void whenABookNotFoundMessage() {
        final String expectedResult = "Sorry, this book dont exist, try again";
        assertEquals(expectedResult, Messages.bookNotExist());
    }

    @Test
    public void whenABookCheckingEnteredOnMenuMessage() {
        final String expectedResult = "Please, enter to name of your book to checkin";
        assertEquals(expectedResult, Messages.enterYourBookToCheckin());
    }

    @Test
    public void whenABookCheckingHasFailed() {
        final String expectedResult = "Thats is not a valid book to return!";
        assertEquals(expectedResult, Messages.checkinABookFailed());
    }

    @Test
    public void whenABookCheckinHasSucesseful() {
        final String expectedResult =  "Thank you to returning the book";
        assertEquals(expectedResult, Messages.checkinedBookSucesseful());
    }
}
