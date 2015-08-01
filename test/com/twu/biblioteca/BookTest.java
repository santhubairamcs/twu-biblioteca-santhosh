package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void shouldChangeAvailableToFalseOnCheckOut() {
        Book book = new Book("11111", "Train to Pakistan", "Khushwant Singh", 1956, true);

        book.makeUnavailable();

        assertEquals(false, book.isAvailable());
    }

    @Test
    public void shouldChangeAvailableToTrueOnCheckIn() {
        Book book = new Book("11111", "Train to Pakistan", "Khushwant Singh", 1956, false);

        book.makeAvailable();

        assertEquals(true, book.isAvailable());
    }
}
