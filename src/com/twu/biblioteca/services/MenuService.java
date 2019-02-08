package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.*;
import com.twu.biblioteca.helpers.MenuType;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.infra.BookData;
import com.twu.biblioteca.infra.MovieData;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.models.Movie;

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
                System.out.println(Messages.enterYourBookToCheckout());
                try {
                    userInput.nextLine();
                    bookService.checkoutABook(userInput.nextLine());
                } catch (BookCheckoutException ex) {
                    System.out.println(ex.getMessage());
                    break;
                } catch (BookNotFoundException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
                System.out.println(Messages.checkoutedABookSucesseful());
                break;
            }

            case CHECKIGNABOOK: {
                System.out.println(Messages.enterYourBookToCheckin());
                try {
                    userInput.nextLine();
                    bookService.checkingABook(userInput.nextLine());
                } catch (BookCheckinException ex) {
                    System.out.println(ex.getMessage());
                    break;
                } catch (BookNotFoundException ex) {
                    System.out.println(ex.getMessage());
                    break;

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

            case MISSCLICK: {
                throw new MenuItemNotFoundException();
            }
        }
    }

}
