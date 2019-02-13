package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.*;
import com.twu.biblioteca.helpers.MenuType;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.helpers.UserType;
import com.twu.biblioteca.infra.AuthData;
import com.twu.biblioteca.infra.BookData;
import com.twu.biblioteca.infra.MovieData;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    public MenuService(List<MenuItem> menuList) {

        this.menuList = menuList;
    }

    private List<MenuItem> menuList = new ArrayList();

    public List<MenuItem> getMenuList() {
        return this.menuList;
    }

    private User makeLogin(Scanner userInput) throws LoginException, UserNotFoundException {
        System.out.println(Messages.enterLibraryNumber());
        String libraryNumber = userInput.nextLine();
        System.out.println(Messages.enterYourPassword());
        String password = userInput.nextLine();
        AuthService authService = new AuthService(AuthData.users);
        return authService.login(libraryNumber, password);
    }

    public void triggerActionItem(MenuType triggeredOption, Scanner userInput) throws MenuItemNotFoundException {
        BookService bookService = new BookService(BookData.books);
        MovieService movieService = new MovieService(MovieData.movies);
        ProductService productService = new ProductService();
        switch(triggeredOption) {
            case LISTOFBOOKS: {
                System.out.println(Messages.booksInfosMessage(bookService.getAllBooks()));
                break;
            }

            case EXIT: {
                System.out.println(Messages.triggeredExit());
                System.exit(0);
                break;
            }

            case CHECKOUTABOOK: {
                try {
                    userInput.nextLine();
                    User user = this.makeLogin(userInput);
                    System.out.println(Messages.enterYourBookToCheckout());
                    bookService.checkoutABook(userInput.nextLine(), user);
                } catch (BookCheckoutException ex) {
                    System.out.println(ex.getMessage());
                    break;
                } catch (BookNotFoundException ex) {
                    System.out.println(ex.getMessage());
                    break;
                } catch (LoginException ex) {
                    System.out.println(ex);
                } catch (UserNotFoundException ex) {
                    System.out.println(ex);
                }
                System.out.println(Messages.checkoutedABookSucesseful());
                break;
            }

            case CHECKIGNABOOK: {
                try {
                    userInput.nextLine();
                    User user = this.makeLogin(userInput);
                    System.out.println(Messages.enterYourBookToCheckin());
                    bookService.checkingABook(userInput.nextLine(), user);
                } catch (BookCheckinException ex) {
                    System.out.println(ex.getMessage());
                    break;
                } catch (BookNotFoundException ex) {
                    System.out.println(ex.getMessage());
                    break;

                } catch (LoginException ex) {
                    System.out.println(ex);
                } catch (UserNotFoundException ex) {
                    System.out.println(ex);
                }
                System.out.println(Messages.checkinedBookSucesseful());
                break;
            }

            case LISTOFMOVIES: {
                System.out.println(Messages.moviesInfosMessage(movieService.getAllMovies()));
                break;
            }

            case CHECKINGAMOVIE: {
                System.out.println(Messages.enterYourMovieToChecking());
                userInput.nextLine();
                try {
                    Movie movie = movieService.findMovieByName(userInput.nextLine());
                    productService.checkout(movie);
                } catch (MovieNotFoundException e) {
                    System.out.println(e.getMessage());

                } catch (CheckoutException e) {
                    System.out.println(e.getMessage());

                }
                break;
            }

            case LIBRARIANINFOS: {
                userInput.nextLine();
                try {
                    User user = makeLogin(userInput);
                    if (user.getUserType().equals(UserType.ADMIN)) {
                        AuthService authService = new AuthService(AuthData.users);
                        System.out.println(Messages.
                                librarianGetUserInfosMessage(authService.getAllUsersWithTypeCustomer()));
                    }
                } catch (LoginException e) {
                    System.out.println(e);
                } catch (UserNotFoundException e) {
                    System.out.println(e);
                }
                break;

            }

            case USERINFOS: {
                userInput.nextLine();
                try {
                    User user = makeLogin(userInput);
                    if (user.getUserType().equals(UserType.CUSTOMER)) {
                        System.out.println(Messages.userDetailsMessage(user));
                        break;
                    }
                } catch (LoginException e) {
                    System.out.println(e.getMessage());
                    break;
                } catch (UserNotFoundException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }

            case MISSCLICK: {
                throw new MenuItemNotFoundException();
            }
        }
    }

}
