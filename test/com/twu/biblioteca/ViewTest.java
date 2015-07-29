package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ViewTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void out() {
        View view = new View();

        view.greetUser();

        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToShowOutputBook() {
        View view = new View();

        String book[] = {"A Suitable Boy", "Vikram Seth", "1993"};
        view.displayBook(book);

        assertEquals("A Suitable Boy                Vikram Seth         1993      \n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToShowOutputBooksList() {
        Library library;
        String[] book = {"A Suitable Boy", "Vikram Seth ", "1993"};
        ArrayList<String[]> books = new ArrayList<String[]>();
        books.add(book);
        library = new Library(books);
        assertEquals(books, library.getBooks());
    }

    @Test
    public void shouldKnowHowToShowMainMenu() {
        View view = new View();

        view.showMainMenu();

        assertEquals("ListBooks\nQuit\n", outContent.toString());
    }

    @After
    public void cleanUp() {
    }
}
