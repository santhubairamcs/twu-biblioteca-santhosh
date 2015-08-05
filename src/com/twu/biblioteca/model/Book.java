package com.twu.biblioteca.model;


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

    public Book makeUnavailable() {
        if(this.available) {
            this.available = false;
            return this;
        }
        return null;
    }

    public Book makeAvailable() {
        if (!this.available) {
            this.available = true;
            return this;
        }
        return null;
    }

    public boolean hasTitle(String bookTitle) {
        return bookTitle.equals(this.getTitle());
    }
}
