package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public boolean contains(String bookTitle) {
        for(Book book : books) {
            if (bookTitle.equals(book.getTitle()))
                return true;
        }
        return false;
    }

    public boolean remove(String bookTitle) {
        for(Book book : books) {
            if (bookTitle.equals(book.getTitle())) {
                return book.checkout();
            }
        }
        return false;
    }
}
