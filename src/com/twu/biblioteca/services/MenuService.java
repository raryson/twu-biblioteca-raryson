package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.BookAreCheckinedException;
import com.twu.biblioteca.exceptions.BookAreCheckoutedException;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.ItemOnMenuNotFoundException;
import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.models.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    public MenuService() {
        MenuItem exitItem = new MenuItem("Exit", MenuTypes.EXIT, 0);
        MenuItem listOfBookItem = new MenuItem("List All Books", MenuTypes.LISTOFBOOKS, 1);
        MenuItem checkoutABookItem = new MenuItem("Checkout a Book", MenuTypes.CHECKOUTABOOK, 2);
        MenuItem checkingABook = new MenuItem("Checking a Book", MenuTypes.CHECKIGNABOOK, 3);

        menuList.add(exitItem);
        menuList.add(listOfBookItem);
        menuList.add(checkoutABookItem);
        menuList.add(checkingABook);
    }

    private ArrayList<MenuItem> menuList = new ArrayList();

    public ArrayList<MenuItem> getMenuList() {
        return this.menuList;
    }

    public void triggerActionItem(MenuTypes triggeredOption, Scanner userInput, BookService bookService) throws ItemOnMenuNotFoundException {
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
                } catch (BookAreCheckoutedException ex) {
                    System.out.println(Messages.checkoutedABookFailed());
                    break;
                } catch (BookNotFoundException ex) {
                    System.out.println(Messages.bookNotExist());
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
                } catch (BookAreCheckinedException ex) {
                    System.out.println(Messages.checkinABookFailed());
                    break;
                } catch (BookNotFoundException ex) {
                    System.out.println(Messages.bookNotExist());
                    break;

                }
                System.out.println(Messages.checkinedBookSucesseful());
                break;
            }

            case MISSCLICK: {
                throw new ItemOnMenuNotFoundException();
            }
        }
    }

}
