package com.twu.biblioteca.services;

import com.twu.biblioteca.models.Book;

import java.util.ArrayList;

public class BookService {
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> bookResources = new ArrayList<Book>();
        Book book1 = new Book("1984", "George Orwell", "07/01/1996");
        bookResources.add(book1);

        Book book2 = new Book("Harry Potter", "J.K Rolling", "07/01/2006");
        bookResources.add(book2);

        Book book3 = new Book("Matrix", "Lana Wachowski and Lilly Wachowski", "07/01/2016");
        bookResources.add(book3);

        return bookResources;
    };
}
