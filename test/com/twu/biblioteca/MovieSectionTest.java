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

    @Test
    public void shouldKnowsHowCheckOutMovieIfItAvailable() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        MovieSection movieSection = new MovieSection(availableMovies);

        assertEquals(movie1, movieSection.checkout("bahubali"));
    }

    @Test
    public void shouldKnowsHowCheckOutMovieIfItIsNotAvailable() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        MovieSection movieSection = new MovieSection(availableMovies);

        assertEquals(null, movieSection.checkout("the"));
    }

    @Test
    public void shouldKnowsHowToListCheckedOutMovies() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        ArrayList<Movie> checkOutAllMoviesList = new ArrayList<Movie>();
        Movie movie3 = new Movie("bahubali", "rajamouli", 2015, 9, false);
        Movie movie4 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, false);
        availableMovies.add(movie3);
        availableMovies.add(movie4);
        MovieSection movieSection = new MovieSection(availableMovies);

        movieSection.checkout("bahubali");
        movieSection.checkout("The Shawshank Redemption");

        assertEquals(checkOutAllMoviesList, movieSection.getCheckedOutBooks());
    }
}
