package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class MovieSectionTest {

    @Test
    public void shouldKnowsHowMovieIsNotInTheLibrary() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        MovieSection movieSection = new MovieSection(availableMovies);

        assertEquals(null, movieSection.getMovieByTitle("bahubal"));
    }


    @Test
    public void shouldKnowsHowMovieIsInTheLibrary() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        MovieSection movieSection = new MovieSection(availableMovies);

        assertEquals(movie1, movieSection.getMovieByTitle("bahubali"));
    }
}
