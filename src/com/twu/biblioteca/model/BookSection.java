package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.HashMap;


public class BookSection {
    private ArrayList<Book> books;
    private HashMap<Book, User> checkedBooks;

    public BookSection(ArrayList<Book> books, HashMap<Book, User> checkedBooks) {
        this.books = books;
        this.checkedBooks = checkedBooks;
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

    public Book checkOut(String bookTitle, User user) {
        for(Book book : books) {
            if (book.hasTitle(bookTitle)) {
                Book checkedBook = book.checkOut();
                if (checkedBook != null) {
                    checkedBooks.put(checkedBook, user);
                    return checkedBook;
                }
            }
        }
        return null;
    }

    public Book checkIn(String bookTitle, User user) {
        for(Book book : checkedBooks.keySet()) {
            if (book.hasTitle(bookTitle) && user.equals(checkedBooks.get(book))) {
                Book checkedBook = book.checkIn();
                if (checkedBook != null) {
                    checkedBooks.remove(checkedBook);
                    return checkedBook;
                }
            }
        }
        return null;
    }

    public HashMap<Book, User> getCheckedOutBooks() {
        return checkedBooks;
    }
}
