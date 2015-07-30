package com.twu.biblioteca;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private final int yearOfPublish;
    private boolean available;

    public Book(String id, String title, String author, int yearOfPublish, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean checkout() {
        if(this.available) {
            this.available = false;
            return true;
        }
        return false;
    }
}
