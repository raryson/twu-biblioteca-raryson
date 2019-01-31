package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.BookStatus;

public class Book {

    public Book(String name, String author, String publishDate, BookStatus status){
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.status = status;
    }

    private String author;
    private String publishDate;
    private String name;
    private BookStatus status;

    public String getAuthor() {
        return author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getName() {
        return name;
    }

    public BookStatus getStatus() {
        return status;
    }
}
