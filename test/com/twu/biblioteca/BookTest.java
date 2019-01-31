package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void WhenUserNeedToViewAllBooks() {
        ArrayList<String> stubBookList = new ArrayList<String>();
        stubBookList.add("1984");
        stubBookList.add("Harry Potter");
        stubBookList.add("Matrix");

        Book book = new Book();

        assertEquals(book.getAllBooks(), stubBookList);
    }
}
