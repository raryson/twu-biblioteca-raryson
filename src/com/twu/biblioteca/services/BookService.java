package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.BookCheckinException;
import com.twu.biblioteca.exceptions.BookCheckoutException;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.helpers.BookStatus;
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
        List<Book> filteredBooks = books.stream().filter(p -> p.getStatus().equals(BookStatus.AVAILABLE))
                .collect(Collectors.toList());
        return filteredBooks;
    };

    private Book findABookByName(String name){
        Optional<Book> iteredBook = books.stream().filter(book -> book.getName().equals(name)).findFirst();
        return iteredBook.orElse(null);
    }

    public void checkoutABook(String bookName) throws BookCheckoutException, BookNotFoundException {
        Book searchedBook =  findABookByName(bookName);
        if (searchedBook == null) {
            throw new BookNotFoundException();
        }
        if(searchedBook.getStatus().equals(BookStatus.RENTED)) {
            throw new BookCheckoutException();
        }
        this.books.remove(searchedBook);
        searchedBook.setStatus(BookStatus.RENTED);
        this.books.add(searchedBook);
    }

    public void checkingABook(String bookName) throws BookCheckinException, BookNotFoundException {
        Book searchedBook =  findABookByName(bookName);
        if (searchedBook == null) {
            throw new BookNotFoundException();
        }
        if(searchedBook.getStatus().equals(BookStatus.AVAILABLE)) {
            throw new BookCheckinException();
        }
        this.books.remove(searchedBook);
        searchedBook.setStatus(BookStatus.AVAILABLE);
        this.books.add(searchedBook);
    }

    public BookStatus checkBookStatus(String bookName){
        return findABookByName(bookName).getStatus();
    }
}
