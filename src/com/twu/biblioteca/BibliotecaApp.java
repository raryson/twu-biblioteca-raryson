package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.MenuItemNotFoundException;
import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.infra.BookData;
import com.twu.biblioteca.infra.MenuData;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.MenuService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.helloMessage());
        BookData.generateLibrary();
        MenuData.generateMenuList();
        MenuService menuService = new MenuService(MenuData.menuList);
        BookService bookService = new BookService(BookData.books);
        Scanner userInput = new Scanner(System.in);
        while(true){
            try {
                System.out.println(Messages.menuInfoMessage(menuService.getMenuList()));
                int readedInt = userInput.nextInt();
                menuService.triggerActionItem(
                        MenuTypes.valueOf(readedInt).orElse(MenuTypes.MISSCLICK),
                        userInput,
                        bookService);

            } catch (MenuItemNotFoundException e) {
                userInput.nextLine();
                System.out.println(e.getMessage());
            } catch (InputMismatchException ex) {
                userInput.nextLine();
                System.out.println(Messages.triggeredInvalidMenu());
            }
        }

    }
}
