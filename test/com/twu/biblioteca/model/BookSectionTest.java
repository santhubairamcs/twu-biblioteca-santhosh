package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class BookSectionTest {
    ArrayList<Book> books;
    HashMap<Book, User> checkedBooks;
    User user;
    Book book;
    BookSection bookSection;

    @Before
    public void setUp() {
        books = new ArrayList<Book>();
        checkedBooks = new HashMap<Book, User>();
        user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        bookSection = new BookSection(books, checkedBooks);
    }

    @Test
    public void shouldKnowsHowToListBooksOfLibrary() {
        ArrayList<Book> booksFromLibrary = bookSection.getBooks();

        for(int i = 0;i < books.size(); i++)
            assertEquals(books.get(i), booksFromLibrary.get(i));
    }

    @Test
    public void shouldKnowsThatTheBookIsInLibrary() {
        assertEquals(true, bookSection.contains("A Suitable Boy"));
    }

    @Test
    public void shouldKnowsThatTheBookIsNotInLibrary() {
        assertEquals(false, bookSection.contains("3 Mistakes of My Life"));
    }

    @Test
    public void shouldKnowsThatTheCheckOutIsSuccess() {
        assertEquals(book, bookSection.checkOut("A Suitable Boy", user));
    }

    @Test
    public void shouldKnowsThatTheCheckOutIsFail() {
        Book book2 = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, true);
        books.add(book2);
        BookSection bookSection = new BookSection(books, checkedBooks);

        assertEquals(null, bookSection.checkOut("3 Mistakes of My Life", user));
    }

    @Test
    public void shouldKnowsThatTheBookIsCheckedInTheLibrary() {
        Book book2 = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, false);
        books.add(book2);
        checkedBooks.put(book2, user);
        BookSection bookSection = new BookSection(books, checkedBooks);

        bookSection.checkIn("Cutting For Stone", user);

        assertEquals(true, book2.isAvailable());
    }

    @Test
    public void shouldKnowsThatCheckInIsSuccess() {
        Book book2 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, false);
        books.add(book2);
        BookSection bookSection = new BookSection(books, checkedBooks);
        checkedBooks.put(book2, user);

        assertEquals(book2, bookSection.checkIn("Train to Pakistan", user));
    }

    @Test
    public void shouldKnowsThatCheckInIsFail() {
        Book book2 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, false);
        books.add(book2);
        BookSection bookSection = new BookSection(books, checkedBooks);

        assertEquals(null, bookSection.checkIn("Train to China", user));
    }

    @Test
    public void shouldKnowsHowToReturnListOfCheckedBooks() {
        Book book2 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, true);
        books.add(book2);
        bookSection = new BookSection(books, checkedBooks);
        checkedBooks.put(bookSection.checkOut("A Suitable Boy", user), user);
        checkedBooks.put(bookSection.checkOut("Train to Pakistan", user), user);

        assertEquals(checkedBooks, bookSection.getCheckedOutBooks());
    }
}
