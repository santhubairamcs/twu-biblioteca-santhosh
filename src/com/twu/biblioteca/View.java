package com.twu.biblioteca;

import java.util.ArrayList;


public class View {

    public void greetUser() {
        System.out.println("Welcome to Biblioteca");
    }

    public void displayBook(String[] book) {
        System.out.println(book[0] + " - " + book[1] + " - " + book[2]);
    }
    public void displayBooks(ArrayList<String[]> books) {
        for (int i = 0; i < books.size() ;i++)
            displayBook(books.get(i));
    }
}
