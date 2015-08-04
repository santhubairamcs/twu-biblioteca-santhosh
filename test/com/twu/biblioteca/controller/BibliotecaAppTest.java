package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BookSection;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.MovieSection;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void shouldKnowsWhetherGettingFunctionCalledUsingMock() {
        View viewMock = mock(View.class);
        BookSection bookSection = new BookSection(new ArrayList<Book>());
        MovieSection movieSection = new MovieSection(new ArrayList<Movie>());
        BibliotecaApp biblioteca = new BibliotecaApp(viewMock, bookSection, movieSection);

        biblioteca.start(false);

        verify(viewMock, atLeast(1)).greetUser();
    }
}