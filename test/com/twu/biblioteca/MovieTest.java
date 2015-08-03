package com.twu.biblioteca;

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
}