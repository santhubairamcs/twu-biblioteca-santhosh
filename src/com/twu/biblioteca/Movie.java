package com.twu.biblioteca;

public class Movie {
    private final String title;
    private final String director;
    private final int yearOfRelease;
    private final int rating;
    private boolean available;

    public Movie(String title, String director, int yearOfRelease, int rating, boolean available) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.available = available;
    }

    public boolean hasTitle(String titleThat) {
        return (title.equals(titleThat));
    }

    public Movie makeUnavailable() {
        if (available) {
            this.available = false;
            return this;
        }
        return null;
    }
}
