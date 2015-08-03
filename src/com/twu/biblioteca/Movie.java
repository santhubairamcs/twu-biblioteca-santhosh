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

    public Movie makeAvailable() {
        if (available == false) {
            this.available = true;
            return this;
        }
        return null;
    }

    public boolean isavailable() {
        return available;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-20s%-10s%-10s", title, director, yearOfRelease, rating);
    }
}
