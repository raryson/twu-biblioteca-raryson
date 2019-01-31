package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.helloMessage());
        Menu menu = new Menu();
        Scanner userInput = new Scanner(System.in);
        System.out.println(Messages.menuInfoMessage(menu.getMenuList()));
        if(!menu.triggerActionItem(userInput.nextLine())){
            System.out.println(Messages.triggeredInvalidMenu());
        }
        BookService bookService = new BookService();
        System.out.println(Messages.booksInfosMessage(bookService.getAllBooks()));
    }
}
