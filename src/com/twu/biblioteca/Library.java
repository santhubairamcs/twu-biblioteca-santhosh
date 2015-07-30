package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<String[]> books;
    public Library(ArrayList<String[]> books) {
        this.books = books;
    }

    public ArrayList<String[]> getBooks() {
        return books;
    }

    public boolean contains(String bookTitle) {
        for(String[] book : books) {
            if (book[0].equals(bookTitle))
                return true;
        }
        return false;
    }

    public boolean remove(String bookTitle) {
        for(String[] book : books) {
            if (book[0].equals(bookTitle))
                return books.remove(book);
        }
        return false;
    }
}
