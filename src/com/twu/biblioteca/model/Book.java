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

    public boolean isAvailable() {
        return available;
    }

    public Book checkOut() {
        if(this.available) {
            this.available = false;
            return this;
        }
        return null;
    }

    public Book checkIn() {
        if (!this.available) {
            this.available = true;
            return this;
        }
        return null;
    }

    public boolean hasTitle(String bookTitle) {
        return bookTitle.equals(this.getTitle());
    }

    @Override
    public String toString() {
        return String.format("%-25s%-25s%-25s", title, author, yearOfPublish);
    }
}
