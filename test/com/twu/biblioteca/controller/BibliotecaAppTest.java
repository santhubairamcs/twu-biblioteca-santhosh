package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import java.util.ArrayList;

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

    @Test
    public void shouldKnowsWhatToDoWhenAuthenticationFail(){
        View viewMock = mock(View.class);
        Login loginMock = mock(Login.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(viewMock, new BookSection(new ArrayList<Book>()), new MovieSection(new ArrayList<Movie>()), loginMock);
        when(viewMock.getUserInput()).thenReturn("1");
        bibliotecaApp.userLogin();
        verify(loginMock).authenticate("1", "1");
        when(loginMock.authenticate("000-0001", "12345")).thenReturn(null);
        verify(viewMock).outputConsole("Invalid login, Try again");
    }

    @Test
    public void shouldKnows(){
        View viewMock = mock(View.class);
        Login loginMock = mock(Login.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(viewMock, new BookSection(new ArrayList<Book>()), new MovieSection(new ArrayList<Movie>()), loginMock);
        when(viewMock.getUserInput()).thenReturn("1");
        bibliotecaApp.menuLoop();
        when(loginMock.authenticate("000-0001", "12345")).thenReturn(new User("", "", "", "", "", ""));
    }
}