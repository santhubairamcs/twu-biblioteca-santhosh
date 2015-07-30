package com.twu.biblioteca;

public class CheckIn {
    Library library;

    public CheckIn(Library library) {
        this.library = library;
    }

    public String checkIn(String bookTitle) {
        return "Thank you for returning the book.";
    }
}
