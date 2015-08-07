package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BookSection;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class ViewTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldKnowsHowToShowWelcomeMessage() {
        View view = new View();

        view.greetUser();

        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToShowOutputBook() {
        View view = new View();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth", 1993, true);

        view.displayBook(book);

        assertEquals("A Suitable Boy           Vikram Seth              1993                     \n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToShowOutputBooksList() {
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth", 1993, true);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);
        HashMap<Book, User> checkedBooks = new HashMap<Book, User>();
        BookSection bookSection = new BookSection(books, checkedBooks);

        assertEquals(books, bookSection.getBooks());
    }

    @Test
    public void shouldKnowHowToShowString() {
        View view = new View();

        view.outputConsole("hello");

        assertEquals("hello\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToTakeInputFromConsole() {
        String testString = "test";
        InputStream stream = new ByteArrayInputStream(testString.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String inputString = "";

        try {
            inputString = reader.readLine();
        }
        catch (IOException ex){
            ;
        }

        assertEquals("test", inputString);
    }

    @Test
    public void shouldKnowsHowToDisplaySuccessfulCheckOutStatus() {
        View view = new View();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth", 1993, true);

        view.displayCheckOutStatus(book);

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToDisplayUnsuccessfulCheckOutStatus() {
        View view = new View();
        Book book = null;

        view.displayCheckOutStatus(book);

        assertEquals("That book is not available\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToDisplaySuccessfulCheckInStatus() {
        View view = new View();
        Book book = new Book("11111", "A Suitable Boy", "Vikram Seth", 1993, true);

        view.displayCheckInStatus(book);

        assertEquals("Thank you for returning the book\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToDisplayUnsuccessfulCheckInStatus() {
        View view = new View();
        Book book = null;

        view.displayCheckInStatus(book);

        assertEquals("That is not a valid book to return\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToDisplayCheckOutMoviesList() {
        View view = new View();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, false);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, false);
        movies.add(movie1);
        movies.add(movie2);
        view.displayMoviesList(movies);

        assertEquals("bahubali                 rajamouli                2015                     9                        \n" +
                "The Shawshank Redemption Frank Darabont           1994                     9                        \n", outContent.toString());
    }

    @Test
    public void shouldKnowsThatTheMovieCheckedInSuccessfully() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, false);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, false);
        movies.add(movie1);
        movies.add(movie2);
        View view = new View();

        view.displayCheckInMoviesStatus(movie1);

        assertEquals("Thank you for returning the movie\n", outContent.toString());
    }

    @Test
    public void shouldKnowsThatTheMovieCheckedInUnSuccessful() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, false);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, false);
        movies.add(movie1);
        movies.add(movie2);
        View view = new View();

        view.displayCheckInMoviesStatus(null);

        assertEquals("That is not a valid movie to return\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowTodisplayUserProfile() {
        View view = new View();

        view.displayUserProfile("hello");

        assertEquals("User Name                Email                    Mobile Number            \n"+"hello\n", outContent.toString());
    }

    @Test
    public void shouldKnowsHowToListCheckedMovies() {
        View view = new View();
        HashMap<Movie, User> movies = new HashMap<Movie, User>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, false);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, false);
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        movies.put(movie1, user);
        movies.put(movie2, user);

//        view.displayCheckedBooks(movies);
    }
}
