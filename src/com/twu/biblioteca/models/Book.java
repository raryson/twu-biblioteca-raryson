package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.ProductStatus;

public class Book extends Product {

    public Book(String name, String author, String publishDate, ProductStatus status){
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.status = status;
    }

    private String author;
    private String publishDate;
    private String name;

    public String getAuthor() {
        return author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getName() {
        return name;
    }
}
