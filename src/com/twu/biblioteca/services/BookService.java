package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.BookAreCheckoutedException;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.helpers.BookStatus;
import com.twu.biblioteca.helpers.Messages;
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
        if(searchedBook.getStatus() == BookStatus.RENTED) {
            throw new BookAreCheckoutedException();
        }
        searchedBook.setStatus(BookStatus.RENTED);
    }

    public BookStatus checkBookStatus(String bookName){
        return findABookByName(bookName).getStatus();
    }
}
