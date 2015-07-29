package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;


public class BibliotecaTest {
    @Test
    public void shouldKnowsWheterGettingFunctionCalledUsingMock() {
        View viewMock = mock(View.class);
        BibliotecaApp biblioteca = new BibliotecaApp(viewMock);

        biblioteca.start();

        verify(viewMock, atLeast(1)).greetUser();
    }
}