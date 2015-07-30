package com.twu.biblioteca;


public class CheckIn {
    Library library;

    public CheckIn(Library library) {
        this.library = library;
    }

    public String checkIn(String bookTitle) {
        if(library.contains(bookTitle)) {
            if(library.add(bookTitle)) {
                return "Thank you for returning the book.";
            }
            else {
                return "CheckIn unsuccessful.";
            }
        }
        return "That is not a valid book to return.";
    }
}
