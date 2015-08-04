package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;


public class BookSection {
    private ArrayList<Book> books;

    public BookSection(ArrayList<Book> books) {
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

    public Book checkOut(String bookTitle) {
        for(Book book : books) {
            if (book.hasTitle(bookTitle)) {
                return book.makeUnavailable();
            }
        }
        return null;
    }

    public Book checkIn(String bookTitle) {
        for(Book book : books) {
            if (book.hasTitle(bookTitle)) {
                return book.makeAvailable();
            }
        }
        return null;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        ArrayList<Book> checkedBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (!book.isAvailable())
                checkedBooks.add(book);
        }
        return checkedBooks;
    }
}
