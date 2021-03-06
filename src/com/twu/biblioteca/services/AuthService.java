package com.twu.biblioteca.services;

import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.helpers.UserType;
import com.twu.biblioteca.models.User;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthService {
    List<User> users = new ArrayList<User>();

    public AuthService(List<User> users) {
        this.users = users;
    }

    private User findUserByLibraryNumber(String libraryNumber) throws UserNotFoundException {
        Optional<User> iteredUser= users
                .stream()
                .filter(user -> user.getLibraryNumber().equals(libraryNumber))
                .findFirst();
        return iteredUser.orElseThrow(() -> new UserNotFoundException());
    }

    public User login(String libraryNumber, String password) throws UserNotFoundException, LoginException {
        User user = findUserByLibraryNumber(libraryNumber);
        if (!user.getPassword().equals(password)) {
            throw new LoginException();
        }
        return user;
    }

    public List<User> getAllUsersWithTypeCustomer() {
        List<User> iteredUser = users
                .stream()
                .filter(user -> user.getUserType().equals(UserType.CUSTOMER))
                .collect(Collectors.toList());
        return iteredUser;
    }
}
