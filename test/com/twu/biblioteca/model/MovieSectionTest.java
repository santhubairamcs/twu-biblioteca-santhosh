package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class MovieSectionTest {
    User user;
    ArrayList<Movie> availableMovies;
    Movie movie1, movie2;
    HashMap<Movie, User> checkedMovies;

    @Before
    public void setUp() {
        user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        availableMovies = new ArrayList<Movie>();
        movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        checkedMovies = new HashMap<Movie, User>();
    }

    @Test
    public void shouldKnowsHowMovieIsNotInTheLibrary() {
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(null, movieSection.getMovieByTitle("bahubal"));
    }


    @Test
    public void shouldKnowsHowMovieIsInTheLibrary() {
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(movie1, movieSection.getMovieByTitle("bahubali"));
    }

    @Test
    public void shouldKnowsHowCheckOutMovieIfItAvailable() {
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(movie1, movieSection.checkOut("bahubali", user));
    }

    @Test
    public void shouldKnowsHowCheckOutMovieIfItIsNotAvailable() {
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(null, movieSection.checkOut("the", user));
    }

    @Test
    public void shouldKnowsHowToReturnListOfMovies() {
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(availableMovies, movieSection.getMovies());
    }

    @Test
    public void shouldKnowsHowCheckInMovie() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, false);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        HashMap<Movie, User> checkedMovies = new HashMap<Movie, User>();
        checkedMovies.put(movie1, user);
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(movie1, movieSection.checkIn("bahubali", user));
    }
}
