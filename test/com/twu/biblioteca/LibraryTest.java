package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class LibraryTest {

    @Test
    public void shouldKnowsHowToListBooksOfLibrary() {
        String[] book = {"A Suitable Boy", "Vikram Seth ", "1993"};
        ArrayList<String[]> books = new ArrayList<String[]>();
        Library library = new Library(books);
        books.add(book);

        ArrayList<String[]> booksFromLibrary = library.getBooks();

        for(int i = 0;i < books.size(); i++)
            assertArrayEquals(books.get(i), booksFromLibrary.get(i));
    }

    @Test
    public void shouldKnowsHowBookIsInLibrary() {
        String[] book = {"A Suitable Boy", "Vikram Seth ", "1993"};
        ArrayList<String[]> books = new ArrayList<String[]>();
        Library library = new Library(books);
        books.add(book);

        assertEquals(true, library.contains("A Suitable Boy"));
    }
}
