package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieSection {
    ArrayList<Movie> availableMovies = new ArrayList<Movie>();

    public MovieSection(ArrayList<Movie> availableMovies) {
        this.availableMovies = availableMovies;
    }

    public Movie getMovieByTitle(String title) {
        return null;
    }
}
