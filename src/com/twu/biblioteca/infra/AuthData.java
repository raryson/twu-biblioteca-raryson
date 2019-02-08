package com.twu.biblioteca.infra;

import com.twu.biblioteca.helpers.UserType;
import com.twu.biblioteca.models.User;

import java.util.ArrayList;
import java.util.List;

public class AuthData {

    public static List<User> users;

    public static void generateUsers() {
        users = new ArrayList<User>();

        User user = new User("Raryson", "raryson.rost@gmail.com", "5551986598986",
                UserType.CUSTOMER, "111-1111",
                "123");
        users.add(user);

        User liberaryPerson = new User("Pedro", "pedro@gmail.com", "5134972877",
                UserType.ADMIN, "000-0000",
                "123");
        users.add(liberaryPerson);
    }
}
