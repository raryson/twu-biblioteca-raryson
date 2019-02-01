package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.BookAreCheckinedException;
import com.twu.biblioteca.exceptions.BookAreCheckoutedException;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.helpers.BookStatus;
import com.twu.biblioteca.models.Book;

import java.util.ArrayList;

public class BookService {
    public BookService(){
        Book book1 = new Book("1984", "George Orwell", "07/01/1996", BookStatus.AVAILABLE);
        this.books.add(book1);

        Book book2 = new Book("Harry Potter", "J.K Rolling", "07/01/2006",
                                BookStatus.AVAILABLE);
        this.books.add(book2);

        Book book3 = new Book("Matrix", "Lana Wachowski and Lilly Wachowski", "07/01/2016",
                                BookStatus.AVAILABLE);
        this.books.add(book3);

        Book book4 = new Book("The Battle of the Apocalipse", "Eduardo Sphor", "07/01/2026",
                BookStatus.RENTED);
        this.books.add(book4);

    }

    private ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getAllBooks() {
        return this.books;
    };

    private Book findABookByName(String name){
        for(Book iteredBook : books){
            if(iteredBook.getName().equals(name))
                return iteredBook;

        }
        return null;
    }

    public void checkoutABook(String bookName) throws BookAreCheckoutedException, BookNotFoundException {
        Book searchedBook =  findABookByName(bookName);
        if (searchedBook == null) {
            throw new BookNotFoundException();
        }
        if(searchedBook.getStatus().equals(BookStatus.RENTED)) {
            throw new BookAreCheckoutedException();
        }
        this.books.remove(searchedBook);
        searchedBook.setStatus(BookStatus.RENTED);
        this.books.add(searchedBook);
    }

    public void checkingABook(String bookName) throws BookAreCheckinedException, BookNotFoundException {
        Book searchedBook =  findABookByName(bookName);
        if (searchedBook == null) {
            throw new BookNotFoundException();
        }
        if(searchedBook.getStatus().equals(BookStatus.AVAILABLE)) {
            throw new BookAreCheckinedException();
        }
        this.books.remove(searchedBook);
        searchedBook.setStatus(BookStatus.AVAILABLE);
        this.books.add(searchedBook);
    }

    public BookStatus checkBookStatus(String bookName){
        return findABookByName(bookName).getStatus();
    }
}
