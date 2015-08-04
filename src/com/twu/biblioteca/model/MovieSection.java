package com.twu.biblioteca.model;

import java.util.ArrayList;

public class MovieSection {
    ArrayList<Movie> availableMovies;

    public MovieSection(ArrayList<Movie> availableMovies) {
        this.availableMovies = availableMovies;
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : availableMovies) {
            if (movie.hasTitle(title))
                return movie;
        }
        return null;
    }

    public Movie checkout(String title) {
        Movie movie = getMovieByTitle(title);
        if (movie != null)
            return movie.makeUnavailable();
        return null;
    }

    public ArrayList<Movie> getCheckedOutBooks() {
        ArrayList<Movie> checkedMovies = new ArrayList<Movie>();
        for (Movie movie : availableMovies) {
            if (!movie.isavailable())
                checkedMovies.add(movie);
        }
        return checkedMovies;
    }

    public ArrayList<Movie> getMovies() {
        return availableMovies;
    }

    public Movie checkin(String title) {
        Movie movie = getMovieByTitle(title);
        if (movie != null)
            return movie.makeAvailable();
        return null;
    }
}
