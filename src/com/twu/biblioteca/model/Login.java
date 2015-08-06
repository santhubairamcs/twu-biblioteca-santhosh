package com.twu.biblioteca.model;

import com.twu.biblioteca.model.User;

import java.util.ArrayList;


public class Login {
    ArrayList<User> users;

    public Login(ArrayList<User> users) {
        this.users = users;
    }
    public User authenticate(String libraryNumber, String password) {
        for (User user : users) {
            if (user.authenticate(libraryNumber, password))
                return user;
        }
        return null;
    }
}
