package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void shouldKnowsWhetherGettingFunctionCalledUsingMock() {
        View viewMock = mock(View.class);
        Library library = new Library(new ArrayList<Book>());
        MovieSection movieSection = new MovieSection(new ArrayList<Movie>());
        BibliotecaApp biblioteca = new BibliotecaApp(viewMock, library, movieSection);

        biblioteca.start(false);

        verify(viewMock, atLeast(1)).greetUser();
    }
}