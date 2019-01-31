package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.helloMessage());
        BookService bookService = new BookService();
        System.out.println(Messages.booksInfosMessage(bookService.getAllBooks()));
    }
}
