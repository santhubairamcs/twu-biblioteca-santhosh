package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class CheckOutTest {

    @Test
    public void shouldKnowThatTheBookIsInLibraryIsCheckout() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book);
        Library library = new Library(books);
        CheckOut checkout = new CheckOut(library);

        assertEquals(book, checkout.checkOut("A Suitable Boy"));
    }
}
