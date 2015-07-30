package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckOutTest {

    @Test
    public void shouldKnowThatTheBookIsInLibraryIsCheckout() {
        ArrayList<String[]> books = new ArrayList<String[]>();
        String[] book1 = {"A Suitable Boy", "Vikram Seth ", "1993"};
        String[] book2 = {"Cutting For Stone", "Abraham Verghese", "2009"};
        String[] book3 = {"The White Tiger", "Aravind Adiga", "2008"};
        String[] book4 = {"Train to Pakistan", "Khushwant Singh", "1956"};
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Library library = new Library(books);
        CheckOut checkout = new CheckOut(library);

        checkout.checkOut("A Suitable Boy");

        assertEquals(false, library.contains("A Suitable Boy"));
    }
}
