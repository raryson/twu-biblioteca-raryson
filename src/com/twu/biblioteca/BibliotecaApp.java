package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.ItemOnMenuNotFoundException;
import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.services.BookService;
import com.twu.biblioteca.services.MenuService;

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

                menuService.triggerActionItem(
                        MenuTypes.valueOf(userInput.nextInt()).orElse(null),
                        userInput,
                        bookService);

            } catch (ItemOnMenuNotFoundException e) {
                System.out.println(Messages.triggeredInvalidMenu());
            }
        }

    }
}
