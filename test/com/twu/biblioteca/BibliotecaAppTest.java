package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void shouldKnowsWhetherGettingFunctionCalledUsingMock() {
        View viewMock = mock(View.class);
        BibliotecaApp biblioteca = new BibliotecaApp(viewMock,new ArrayList<String[]>());

        biblioteca.start(false);

        verify(viewMock, atLeast(1)).greetUser();
    }


}