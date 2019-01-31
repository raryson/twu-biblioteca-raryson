package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {

    public Book(String name, String author, String publishDate){
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
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
