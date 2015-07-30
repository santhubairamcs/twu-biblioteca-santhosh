package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class CheckOutTest {

    @Test
    public void shouldKnowThatTheBookIsInLibraryIsCheckout() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        books.add(book1);
        Library library = new Library(books);
        CheckOut checkout = new CheckOut(library);

        checkout.checkOut("A Suitable Boy");

        assertEquals(false, library.contains("A Suitable Boy"));
    }
}
