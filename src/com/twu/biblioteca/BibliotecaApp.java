package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    View view ;
    Library library;
    ArrayList<String[]> books;

    public BibliotecaApp(View view, ArrayList<String[]> books){
        this.view = view;
        this.books = books;
        library = new Library(books);
    }

    public void start() {
        view.greetUser();
        view.listBooks(library.getBooks());
    }
}