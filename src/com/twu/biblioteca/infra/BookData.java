package com.twu.biblioteca.infra;

import com.twu.biblioteca.helpers.ProductStatus;
import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookData {
    public static List<Book> books;

    public static void generateLibrary () {
        books = new ArrayList<>();
        Book book1 = new Book("1984", "George Orwell", "07/01/1996", ProductStatus.AVAILABLE);
        books.add(book1);

        Book book2 = new Book("Harry Potter", "J.K Rolling", "07/01/2006",
                ProductStatus.AVAILABLE);
        books.add(book2);

        Book book3 = new Book("Matrix", "Lana Wachowski and Lilly Wachowski", "07/01/2016",
                ProductStatus.AVAILABLE);
        books.add(book3);

        Book book4 = new Book("The Battle of the Apocalipse", "Eduardo Sphor", "07/01/2026",
                ProductStatus.RENTED);
        books.add(book4);
    }

}
