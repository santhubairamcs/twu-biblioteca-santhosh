package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class CheckInTest {

    @Test
    public void shouldKnowsThatCheckInIsSuccess() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, false);
        books.add(book1);
        books.add(book2);
        Library library = new Library(books);
        CheckIn checkin = new CheckIn(library);

        assertEquals("Thank you for returning the book.", checkin.checkIn("Train to Pakistan"));
    }
}
