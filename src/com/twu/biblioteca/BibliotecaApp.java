package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.ItemOnMenuNotFoundException;
import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.MenuService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.helloMessage());
        MenuService menuService = new MenuService();
        BookService bookService = new BookService();
        Scanner userInput = new Scanner(System.in);
        while(true){
            try {
                System.out.println(Messages.menuInfoMessage(menuService.getMenuList()));
                int readedInt = userInput.nextInt();
                menuService.triggerActionItem(
                        MenuTypes.valueOf(readedInt).orElse(MenuTypes.MISSCLICK),
                        userInput,
                        bookService);

            } catch (ItemOnMenuNotFoundException e) {
                userInput.nextLine();
                System.out.println(Messages.triggeredInvalidMenu());
            } catch (InputMismatchException ex) {
                userInput.nextLine();
                System.out.println(Messages.triggeredInvalidMenu());
            }
        }

    }
}
