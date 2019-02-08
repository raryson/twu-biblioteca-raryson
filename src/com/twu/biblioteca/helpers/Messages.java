package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.models.Movie;

import java.util.List;

public class Messages {
    public static String helloMessage(){
        return "Welcome to Biblioteca." +
            " Your one-stop-shop for great book title in Bangalore!";
    }

    public static String booksInfosMessage(List<Book> booksList){
        String booksMessage = "\tBook Name\tAuthor\tPublish Date\n";
        for(Book book : booksList){
            booksMessage += String.format("\t%s\t%s\t%s\n", book.getName(), book.getAuthor(), book.getPublishDate());
        }
        return booksMessage;
    }

    public static String moviesInfosMessage(List<Movie> allMovies) {
        String movieMessage = "\tMovie Name\tDirector\tYear\tRating\n";
        for(Movie movie : allMovies){
            movieMessage += String.format("\t%s\t%s\t%s\t%s\n", movie.getName(), movie.getDirector(),
                    movie.getYear(), movie.getRating());
        }
        return movieMessage;
    }

    public static String menuInfoMessage(List<MenuItem> menuItens){
        String menuMessage = "Please, select one of this options:\n";
        for(MenuItem itens : menuItens){
            menuMessage += String.format("\n%s - %s", itens.getNumber(), itens.getName());
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

    public static String productNotExist() {
        return "Sorry, this product dont exist, try again";
    }

    public static String checkoutedFailed() {
        return "Sorry, that product is not available";
    }

    public static String movieNotFound(){
        return "Sorry, that product is not available";
    }

    public static String enterYourMovieToChecking() {
        return "Enter with a movie name to checkin";
    }

    public static String userNotexist() {
        return "Error at login, try again later";
    }

    public static String enterLibraryNumber() {
        return "Enter with you library number:";
    }

    public static String enterYourPassword() {
        return "Enter with you password:";
    }
}
