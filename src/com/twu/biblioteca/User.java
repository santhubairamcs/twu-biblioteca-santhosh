package com.twu.biblioteca;

public class User {
    private final String name;
    private final String email;
    private final String password;
    private final String libraryNumber;
    private final String phone;
    private final String role;

    public User(String name, String email, String phone, String libraryNumber, String password, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
    }


    public boolean authenticate(String libraryNumber, String password) {
        return (this.libraryNumber == libraryNumber && this.password == password);
    }

    @Override
    public String toString() {
        return String.format("%-25s%-25s%-25s%-25s", name, email, phone,role );
    }
}