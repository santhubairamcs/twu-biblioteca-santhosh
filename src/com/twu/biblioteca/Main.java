package com.twu.biblioteca;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, true);
        Book book3 = new Book("33333","The White Tiger", "Aravind Adiga", 2008, true);
        Book book4 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, true);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        View view = new View();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(view , books);
        bibliotecaApp.start(true);
    }
}
