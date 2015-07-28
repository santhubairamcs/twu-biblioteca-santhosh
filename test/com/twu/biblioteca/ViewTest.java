package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @After
    public void cleanUp() {
        System.setOut(null);
    }
}
