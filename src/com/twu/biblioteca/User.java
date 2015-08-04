package com.twu.biblioteca;

public class User {
    private final String name;
    private final String email;
    private final String password;
    private final String libraryNumber;
    private final String phone;

    public User(String name, String email, String phone, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }


    public boolean authenticate(String libraryNumber, String password) {
        return (this.libraryNumber == libraryNumber && this.password == password);
    }
}
