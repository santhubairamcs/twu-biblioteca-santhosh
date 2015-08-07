package com.twu.biblioteca.model;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<Movie, User> checkedMovies = new HashMap<Movie, User>();
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(null, movieSection.getMovieByTitle("bahubal"));
    }


    @Test
    public void shouldKnowsHowMovieIsInTheLibrary() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        HashMap<Movie, User> checkedMovies = new HashMap<Movie, User>();
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(movie1, movieSection.getMovieByTitle("bahubali"));
    }

    @Test
    public void shouldKnowsHowCheckOutMovieIfItAvailable() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        HashMap<Movie, User> checkedMovies = new HashMap<Movie, User>();
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(movie1, movieSection.checkOut("bahubali", user));
    }

    @Test
    public void shouldKnowsHowCheckOutMovieIfItIsNotAvailable() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        HashMap<Movie, User> checkedMovies = new HashMap<Movie, User>();
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        assertEquals(null, movieSection.checkOut("the", user));
    }

    @Test
    public void shouldKnowsHowToListCheckedOutMovies() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
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
        HashMap<Movie, User> checkedMovies = new HashMap<Movie, User>();
        MovieSection movieSection = new MovieSection(availableMovies, checkedMovies);

        movieSection.checkOut("bahubali", user);
        movieSection.checkOut("The Shawshank Redemption", user);
        ArrayList<Movie> checked = movieSection.getCheckedOutMovies();
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
        HashMap<Movie, User> checkedMovies = new HashMap<Movie, User>();
        MovieSection movieSection = new MovieSection(movies, checkedMovies);

        assertEquals(movies, movieSection.getMovies());
    }

    @Test
    public void shouldKnowsHowCheckInMovie() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
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
