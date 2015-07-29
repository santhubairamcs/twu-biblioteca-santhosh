package com.twu.biblioteca;

import java.util.ArrayList;


public class View {

    public void greetUser() {
        System.out.println("Welcome to Biblioteca");
    }

    public void displayBook(String[] book) {
        System.out.format("%-30s%-20s%-10s\n", book[0], book[1], book[2]);
    }

    public void listBooks(ArrayList<String[]> books) {
        for (int i = 0; i < books.size() ;i++)
            displayBook(books.get(i));
    }

    public void showMainMenu(){
        System.out.println("ListBooks");
        System.out.println("Quit");
    }
}
