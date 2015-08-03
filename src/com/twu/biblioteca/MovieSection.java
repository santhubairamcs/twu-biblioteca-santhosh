package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieSection {
    ArrayList<Movie> availableMovies = new ArrayList<Movie>();

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
}
