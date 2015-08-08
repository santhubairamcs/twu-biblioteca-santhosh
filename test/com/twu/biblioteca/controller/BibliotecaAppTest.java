package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {
    BibliotecaApp bibliotecaApp;
    View viewMock;
    Login loginMock;
    BookSection bookSectionMock;
    MovieSection movieSectionMock;
    User user, userMock;

    @Before
    public void setUp() {
        viewMock = mock(View.class);
        loginMock = mock(Login.class);
        bookSectionMock = mock(BookSection.class);
        movieSectionMock = mock(MovieSection.class);
        bibliotecaApp = new BibliotecaApp(viewMock, bookSectionMock, movieSectionMock, loginMock);
        user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        userMock = mock(User.class);
    }

    @Test
    public void shouldKnowsWhetherLoginsAuthenticateIsInvokedOrNot(){

        when(viewMock.getUserInput()).thenReturn("1");
        bibliotecaApp.userLogin();
        verify(loginMock).authenticate("1", "1");
     }

    @Test
    public void shouldKnowsWhatToDoWhenAuthenticationFail(){
        when(viewMock.getUserInput()).thenReturn("1");
        bibliotecaApp.userLogin();
        verify(loginMock).authenticate("1", "1");
        when(loginMock.authenticate("000-0001", "12345")).thenReturn(null);
        verify(viewMock).outputConsole("Invalid login, Try again");
    }
}
