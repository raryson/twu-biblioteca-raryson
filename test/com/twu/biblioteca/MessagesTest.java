package com.twu.biblioteca;

import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.infra.AuthData;
import com.twu.biblioteca.infra.BookData;
import com.twu.biblioteca.infra.MenuData;
import com.twu.biblioteca.infra.MovieData;
import com.twu.biblioteca.services.AuthService;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.MenuService;
import com.twu.biblioteca.services.MovieService;
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
    public void whenLibrarianNeedShowHistoricOfCheckins() {
        final String expectedLibrarianMessage = "\tName\tEmail\tPhone\tLibrary Number\n" +
                "\tRaryson\traryson.rost@gmail.com\t5551986598986\t111-1111\n" +
                "\tBooks with Raryson:\n" +
                "\tBook Name\tAuthor\tPublish Date\n" +
                "\t1984 pt 2\tGeorge Orwell\t07/01/1996\n" +
                "\tHarry Potter pt 2\tJ.K Rolling\t07/01/2006\n";

        AuthData.generateUsers();
        AuthService authService = new AuthService(AuthData.users);
        assertEquals(expectedLibrarianMessage,
                Messages.librarianGetUserInfosMessage(authService.getAllUsersWithTypeCustomer()));
    }

    @Test
    public void whenMenuAreShowedOnScreenAssertToEqualToMockedMenuList() {
        final String expectedMenuMessage = "Please, select one of this options:\n\n0 - Exit\n1 - List All Books" +
                "\n2 - Checkout a Book\n3 - Checking a Book\n4 - List All Movies\n5 - Checkin a Movie";
        MenuData.generateMenuList();
        MenuService menuService = new MenuService(MenuData.menuList);
        assertEquals(expectedMenuMessage, Messages.menuInfoMessage(menuService.getMenuList()));
    }

    @Test
    public void whenMovieAreShowedOnScreenAssertToEqualMockedListOfBooks() {
        final String expectedMoviesMessage = "\tMovie Name\tDirector\tYear\tRating\n" +
                "\tMatrix\tLana Wachowski and Lilly Wachowski\t2000\tTEN\n" +
                "\tNarnia\tC. S. Lewis\t2006\tSIX\n";

        MovieData.generateMovies();
        MovieService movieService = new MovieService(MovieData.movies);
        assertEquals(expectedMoviesMessage, Messages.moviesInfosMessage(movieService.getAllMovies()));
    }

}
