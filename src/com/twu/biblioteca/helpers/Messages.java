package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Messages {
    public static String helloMessage(){
        return "Welcome to Biblioteca." +
            " Your one-stop-shop for great book title in Bangalore!";
    }

    public static String booksInfosMessage(List<Book> booksList){
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

    public static String enterYourBookToCheckout() { return "Enter with a book name to checkout"; }

    public static String bookNotExist() { return "Sorry, this book dont exist, try again"; }

    public static String checkoutedABookSucesseful() { return "Thank you! Enjoy the book"; }

    public static String checkinABookFailed() { return "Thats is not a valid book to return!"; }

    public static String checkoutedABookFailed(){ return "Sorry, that book is not available"; }

    public static String checkinedBookSucesseful() { return "Thank you to returning the book"; }

    public static String enterYourBookToCheckin() { return "Please, enter to name of your book to checkin"; }

    public static String triggeredInvalidMenu(){
        return "Sorry, invalid menu input, try again please!";
    }

    public static String triggeredExit(){
        return "Bye bye";
    }

}
