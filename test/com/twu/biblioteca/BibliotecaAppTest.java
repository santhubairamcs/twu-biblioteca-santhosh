package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void shouldKnowsWhetherGettingFunctionCalledUsingMock() {
        View viewMock = mock(View.class);
        BibliotecaApp biblioteca = new BibliotecaApp(viewMock,new ArrayList<String[]>());

        biblioteca.start();

        verify(viewMock, atLeast(1)).greetUser();
    }

    @Test
    public void shouldKnowsWhetherLibraryReturningBooksAndPassingItToView() {
        Library libraryMock = mock(Library.class);
        View viewMock = mock(View.class);
        ArrayList<String[]> books = new ArrayList<String[]>();
        String[] book1 = {"A Suitable Boy", "Vikram Seth ", "1993"};
        String[] book2 = {"Cutting For Stone", "Abraham Verghese", "2009"};
        String[] book3 = {"The White Tiger", "Aravind Adiga", "2008"};
        String[] book4 = {"Train to Pakistan", "Khushwant Singh", "1956"};
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        BibliotecaApp biblioteca = new BibliotecaApp(viewMock, books);
        biblioteca.start();

        when(libraryMock.getBooks()).thenReturn(books);
        verify(viewMock, atLeast(1)).listBooks(books);
    }
}