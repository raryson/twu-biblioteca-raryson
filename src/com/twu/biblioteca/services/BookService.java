package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.helpers.ProductStatus;
import com.twu.biblioteca.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class BookService {
    public BookService(List<Book> generatedBooks) {
        this.books = generatedBooks;
    }

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        List<Book> filteredBooks = books.stream()
                .filter(p -> p.getStatus()
                        .equals(ProductStatus.AVAILABLE))
                .collect(Collectors.toList());
        return filteredBooks;
    };

    public Book findABookByName(String name) throws BookNotFoundException{
        Optional<Book> iteredBook = books
                .stream()
                .filter(book -> book.getName().equals(name))
                .findFirst();
        return iteredBook.orElseThrow(() -> new BookNotFoundException());
    }

}
