package com.twu.biblioteca;


public class CheckOut {
    private final Library library;

    public CheckOut(Library library) {
        this.library = library;
    }

    public Book checkOut(String bookTitle) {
        if(library.contains(bookTitle))
            return library.remove(bookTitle);
        return null;
    }
}
