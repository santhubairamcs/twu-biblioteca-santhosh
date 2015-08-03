package com.twu.biblioteca;

public class Movie {
    private final String title;
    private final String director;
    private final int yearOfRelease;
    private final int rating;
    private final boolean available;

    public Movie(String title, String director, int yearOfRelease, int rating, boolean available) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.available = available;
    }
}
