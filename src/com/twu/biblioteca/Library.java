package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<String[]> books;
    public Library(ArrayList<String[]> books) {
        this.books = books;
    }

    public ArrayList<String[]> listBooks() {
        return books;
    }
}
