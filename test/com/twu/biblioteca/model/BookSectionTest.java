package com.twu.biblioteca.model;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class BookSectionTest {

    @Test
    public void shouldKnowsHowToListBooksOfLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        BookSection bookSection = new BookSection(books);

        ArrayList<Book> booksFromLibrary = bookSection.getBooks();

        for(int i = 0;i < books.size(); i++)
            assertEquals(books.get(i), booksFromLibrary.get(i));
    }

    @Test
    public void shouldKnowsThatTheBookIsInLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        BookSection bookSection = new BookSection(books);

        assertEquals(true, bookSection.contains("A Suitable Boy"));
    }

    @Test
    public void shouldKnowsThatTheBookIsNotInLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        BookSection bookSection = new BookSection(books);

        assertEquals(false, bookSection.contains("3 Mistakes of My Life"));
    }

    @Test
    public void shouldKnowsThatTheCheckOutIsSuccess() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        BookSection bookSection = new BookSection(books);

        assertEquals(book, bookSection.checkOut("A Suitable Boy"));
    }

    @Test
    public void shouldKnowsThatTheCheckOutIsFail() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, true);
        books.add(book1);
        books.add(book2);
        BookSection bookSection = new BookSection(books);

        assertEquals(null, bookSection.checkOut("3 Mistakes of My Life"));
    }

    @Test
    public void shouldKnowsThatTheBookIsCheckedInTheLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, false);
        books.add(book1);
        books.add(book2);
        BookSection bookSection = new BookSection(books);

        bookSection.checkIn("Cutting For Stone");

        assertEquals(true, book2.isAvailable());
    }

    @Test
    public void shouldKnowsThatCheckInIsSuccess() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, false);
        books.add(book1);
        books.add(book2);
        BookSection bookSection = new BookSection(books);

        assertEquals(book2, bookSection.checkIn("Train to Pakistan"));
    }

    @Test
    public void shouldKnowsThatCheckInIsFail() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, false);
        books.add(book1);
        books.add(book2);
        BookSection bookSection = new BookSection(books);

        assertEquals(null, bookSection.checkIn("Train to China"));
    }
}
