package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    View view ;
    Library library;
    ArrayList<String[]> books = new ArrayList<String[]>();

    public BibliotecaApp(View view){
        this.view = view;
        String[] book1 = {"A Suitable Boy", "Vikram Seth ", "1993"};
        String[] book2 = {"Cutting For Stone", "Abraham Verghese", "2009"};
        String[] book3 = {"The White Tiger", "Aravind Adiga", "2008"};
        String[] book4 = {"Train to Pakistan", "Khushwant Singh", "1956"};
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        library = new Library(books);
    }

    public void start() {
        view.greetUser();
    }
}