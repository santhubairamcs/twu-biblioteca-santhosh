package com.twu.biblioteca;


public class CheckOut {

    private final Library library;

    public CheckOut(Library library) {
        this.library = library;
    }

    public String checkOut(String bookTitle) {
        if(library.contains(bookTitle)) {
            if(library.remove(bookTitle))
                return "Thank you! Enjoy the book";
            else
                return "Check out unsuccessful";
        }
        return "That book is not available";
    }
}
