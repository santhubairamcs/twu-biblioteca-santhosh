package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class BibliotecaAppTest {
    BibliotecaApp bibliotecaApp;
    View viewMock;
    Login loginMock;
    BookSection bookSectionMock;
    MovieSection movieSectionMock;
    User user, userMock;
    Book book;
    Book bookMock;

    @Before
    public void setUp() {
        viewMock = mock(View.class);
        loginMock = mock(Login.class);
        bookSectionMock = mock(BookSection.class);
        movieSectionMock = mock(MovieSection.class);
        bibliotecaApp = new BibliotecaApp(viewMock, bookSectionMock, movieSectionMock, loginMock);
        user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        userMock = mock(User.class);
        book = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, true);
        bookMock = mock(Book.class);
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

    @Test
    public void shouldKnowsHowToHandleUserChoiceToListBooks(){
        bibliotecaApp.dispatcher(user, "1");
        verify(bookSectionMock).getBooks();
        verify(viewMock).listBooks(new ArrayList<Book>());
    }

    @Test
    public void shouldKnowsHowToHandleUserChoiceToCheckOutBook(){
        when(viewMock.getUserInput()).thenReturn(anyString());
        when(bookSectionMock.checkOut(anyString(), user)).thenReturn(book);
        bibliotecaApp.dispatcher(user, "2");
        verify(bookSectionMock).checkOut(anyString(), eq(user));
        verify(viewMock).displayCheckOutStatus(book);

    }

    @Test
    public void shouldKnowsHowToHandleUserChoiceToCheckInBook(){
        when(viewMock.getUserInput()).thenReturn(anyString());
        when(bookSectionMock.checkIn(anyString(), user)).thenReturn(book);
        bibliotecaApp.dispatcher(user, "3");
        verify(bookSectionMock).checkIn(anyString(), eq(user));
        verify(viewMock).displayCheckInStatus(book);
    }

    @Test
    public void shouldKnowsHowToHandleUserChoiceToListMovies(){
        when(movieSectionMock.getMovies()).thenReturn(new ArrayList<Movie>());
        bibliotecaApp.dispatcher(user, "4");
        verify(movieSectionMock).getMovies();
        verify(viewMock).displayMoviesList(new ArrayList<Movie>());
    }
}
