package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.MenuItem;

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

    public static String menuInfoMessage(ArrayList<MenuItem> menuItens){
        String menuMessage = "Please, select one of this options:\n";
        for(MenuItem itens : menuItens){
            menuMessage += "\t" + itens.getNumber() + " - " + itens.getName();
        }
        return menuMessage;
    }

    public static String triggeredInvalidMenu(){
        return "Sorry, invalid menu input, try again please!";
    }

    public static String triggeredExit(){
        return "Bye bye";
    }

}
