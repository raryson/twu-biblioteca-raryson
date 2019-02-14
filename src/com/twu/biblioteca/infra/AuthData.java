package com.twu.biblioteca.infra;

import com.twu.biblioteca.helpers.ProductStatus;
import com.twu.biblioteca.helpers.UserType;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;

import java.util.ArrayList;
import java.util.List;

public class AuthData {

    public static List<User> users;

    public static void generateUsers() {
        users = new ArrayList<User>();

        Book book1 = new Book("1984 pt 2", "George Orwell",
                "07/01/1996", ProductStatus.RENTED);
        Book book2 = new Book("Harry Potter pt 2", "J.K Rolling", "07/01/2006",
                ProductStatus.AVAILABLE);


        User user = new User("Raryson", "raryson.rost@gmail.com", "5551986598986",
                UserType.CUSTOMER, "111-1111",
                "123");
        user.addBookOnCheckoutdBooks(book1);
        user.addBookOnCheckoutdBooks(book2);

        users.add(user);

        User liberaryPerson = new User("Pedro", "pedro@gmail.com", "5134972877",
                UserType.ADMIN, "000-0000",
                "123");
        users.add(liberaryPerson);
    }
}
