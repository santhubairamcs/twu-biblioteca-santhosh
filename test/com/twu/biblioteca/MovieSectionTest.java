package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
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
        checkOutAllMoviesList.add(movie3);
        checkOutAllMoviesList.add(movie4);
        MovieSection movieSection = new MovieSection(availableMovies);

        movieSection.checkout("bahubali");
        movieSection.checkout("The Shawshank Redemption");
        ArrayList<Movie> checked = movieSection.getCheckedOutBooks();
        Movie list1[] = new Movie[availableMovies.size()];
        list1 = availableMovies.toArray(list1);
        Movie list2[] = new Movie[checked.size()];
        list2 = checked.toArray(list2);

        assertArrayEquals(list1, list2);
    }

    @Test
    public void shouldKnowsHowToReturnListOfMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        movies.add(movie1);
        movies.add(movie2);
        MovieSection movieSection = new MovieSection(movies);

        assertEquals(movies, movieSection.getMovies());
    }

    @Test
    public void shouldKnowsHowCheckInMovie() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, false);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        MovieSection movieSection = new MovieSection(availableMovies);

        assertEquals(movie1, movieSection.checkin("bahubali"));
    }
}
