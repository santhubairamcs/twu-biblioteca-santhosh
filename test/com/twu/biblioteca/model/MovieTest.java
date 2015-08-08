package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
    }

    @Test
    public void shouldKnowsHowToCheckExistedMovieByTitle() {
        assertEquals(true, movie.hasTitle("The Shawshank Redemption"));
    }

    @Test
    public void shouldKnowsHowToCheckNotExistedMovieByTitle() {
        assertEquals(false, movie.hasTitle("The Shawshank"));
    }

    @Test
    public void shouldKnowsHowToMakeAMovieUnavailable() {
        assertEquals(movie, movie.checkOut());
    }

    @Test
    public void shouldKnowsHowWhetherMovieIsAvailable() {
        assertEquals(true, movie.isavailable());
    }

    @Test
    public void shouldKnowsHowToMakeMovieAvailable() {
        movie.checkIn();

        assertEquals(true, movie.isavailable());
    }
}