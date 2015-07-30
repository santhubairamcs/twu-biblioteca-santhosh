package com.twu.biblioteca;

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
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth", 1993, true);

        view.displayBook(book);

        assertEquals("A Suitable Boy                Vikram Seth         1993      \n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToShowOutputBooksList() {
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth", 1993, true);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        Library library = new Library(books);

        assertEquals(books, library.getBooks());
    }

    @Test
    public void shouldKnowHowToShowMainMenu() {
        View view = new View();

        view.showMainMenu();

        assertEquals("ListBooks\nQuit\n", outContent.toString());
    }

    @Test
    public void shouldKnowHowToShowString() {
        View view = new View();

        view.outputConsole("hello");

        assertEquals("hello\n", outContent.toString());
    }
}
