package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieSection {
    ArrayList<Movie> availableMovies;
    HashMap<Movie, User> checkedMovies;

    public MovieSection(ArrayList<Movie> availableMovies, HashMap<Movie, User> checkedMovies) {
        this.availableMovies = availableMovies;
        this.checkedMovies = checkedMovies;
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : availableMovies) {
            if (movie.hasTitle(title))
                return movie;
        }
        return null;
    }

    public Movie checkOut(String title, User user) {
        Movie movie = getMovieByTitle(title);
        if (movie != null) {
            Movie checkedMovie = movie.checkOut();
            if (checkedMovie != null) {
                checkedMovies.put(checkedMovie, user);
                return checkedMovie;
            }
        }
        return null;
    }

    public HashMap<Movie, User> getCheckedOutMovies() {
        return checkedMovies;
    }

    public ArrayList<Movie> getMovies() {
        return availableMovies;
    }

    public Movie checkIn(String title, User user) {
        for (Movie movie : checkedMovies.keySet()) {
            if (movie.hasTitle(title) && user.equals(checkedMovies.get(movie))) {
                Movie checkedMovie = movie.checkIn();
                if (checkedMovie != null) {
                    checkedMovies.remove(checkedMovie);
                    return checkedMovie;
                }
            }
        }
        return null;
    }
}
