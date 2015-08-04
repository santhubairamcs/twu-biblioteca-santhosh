package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldKnowsHowToCheckExistedMovieByTitle() {
        Movie movie = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);

        assertEquals(true, movie.hasTitle("The Shawshank Redemption"));
    }

    @Test
    public void shouldKnowsHowToCheckNotExistedMovieByTitle() {
        Movie movie = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);

        assertEquals(false, movie.hasTitle("The Shawshank"));
    }

    @Test
    public void shouldKnowsHowToMakeAMovieUnavailable() {
        Movie movie = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);

        assertEquals(movie, movie.makeUnavailable());
    }

    @Test
    public void shouldKnowsHowWhetherMovieIsAvailable() {
        Movie movie = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);

        assertEquals(true, movie.isavailable());
    }

    @Test
    public void shouldKnowsHowToMakeMovieAvailable() {
        Movie movie = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, false);

        movie.makeAvailable();

        assertEquals(true, movie.isavailable());
    }
}