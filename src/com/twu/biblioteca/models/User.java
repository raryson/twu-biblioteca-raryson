package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.UserType;

public class User {
    private String name;
    private String email;
    private String libraryNumber;
    private String password;
    private String phone;
    private UserType userType;

    public User(String name, String email, String phone, UserType userType, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public UserType getUserType() {
        return userType;
    }
}
