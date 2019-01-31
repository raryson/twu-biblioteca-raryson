package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {

    private final String booksResourcesArray[] = { "1984", "Harry Potter", "Matrix" };
    private List<String> booksList = Arrays.asList(booksResourcesArray);

    public List<String> getAllBooks(){
        return this.booksList;
    }

}
