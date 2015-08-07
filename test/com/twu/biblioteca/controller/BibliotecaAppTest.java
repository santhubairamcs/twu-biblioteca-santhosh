package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.internal.matchers.NotNull;

import java.util.ArrayList;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BibliotecaAppTest {

    @Test
    public void shouldKnowsWhetherLoginsAuthenticateIsInvokedOrNot(){
        View viewMock = mock(View.class);
        Login loginMock = mock(Login.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(viewMock, new BookSection(new ArrayList<Book>()), new MovieSection(new ArrayList<Movie>()), loginMock);
        when(viewMock.getUserInput()).thenReturn("1");
        bibliotecaApp.userLogin();
        verify(loginMock).authenticate("1", "1");
     }

}