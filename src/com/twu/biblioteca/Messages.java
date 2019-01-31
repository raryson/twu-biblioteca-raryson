package com.twu.biblioteca;

import java.util.ArrayList;

public class Messages {
    public static String helloMessage(){
        return "Welcome to Biblioteca." +
            " Your one-stop-shop for great book title in Bangalore!";
    }

    public static String booksInfosMessage(ArrayList<Book> booksList){
        String booksMessage = "\tBook Name\tAuthor\tPublish Date\n";
        for(Book book : booksList){
            booksMessage += "\t"+book.getName()+"\t"+book.getAuthor()+"\t"+book.getPublishDate()+"\n";
        }
        return booksMessage;
    }

}
