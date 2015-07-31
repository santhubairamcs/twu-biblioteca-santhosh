package com.twu.biblioteca;


public class CheckIn {
    Library library;

    public CheckIn(Library library) {
        this.library = library;
    }

    public Book checkIn(String bookTitle) {
        if(library.contains(bookTitle)) {
            return library.add(bookTitle);
        }
        return null;
    }
}
