package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void shouldKnowsHowToListBooksOfLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        Library library = new Library(books);

        ArrayList<Book> booksFromLibrary = library.getBooks();

        for(int i = 0;i < books.size(); i++)
            assertEquals(books.get(i), booksFromLibrary.get(i));
    }

    @Test
    public void shouldKnowsThatTheBookIsInLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        Library library = new Library(books);

        assertEquals(true, library.contains("A Suitable Boy"));
    }

    @Test
    public void shouldKnowsThatTheBookIsNotInLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        Library library = new Library(books);

        assertEquals(false, library.contains("3 Mistakes of My Life"));
    }

    @Test
    public void shouldKnowsThatTheCheckOutIsSuccess() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        Library library = new Library(books);

        assertEquals(book, library.checkOut("A Suitable Boy"));
    }

    @Test
    public void shouldKnowsThatTheCheckOutIsFail() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, true);
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);

        assertEquals(null, library.checkOut("3 Mistakes of My Life"));
    }

    @Test
    public void shouldKnowsThatTheBookIsCheckedInTheLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, false);
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);

        library.checkIn("Cutting For Stone");

        assertEquals(true, book2.isAvailable());
    }

    @Test
    public void shouldKnowsThatCheckInIsSuccess() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, false);
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);

        assertEquals(book2, library.checkIn("Train to Pakistan"));
    }

    @Test
    public void shouldKnowsThatCheckInIsFail() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, false);
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);

        assertEquals(null, library.checkIn("Train to China"));
    }
}
