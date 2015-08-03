package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class View {

    public void greetUser() {
        System.out.println("Welcome to Biblioteca");
    }

    public void displayBook(Book book) {
        System.out.format("%-30s%-20s%-10s\n", book.getTitle(), book.getAuthor(), book.getYearOfPublish());
    }

    public void listBooks(ArrayList<Book> books) {
        Book book;
        displayBookHeader();
        for (int i = 0; i < books.size() ;i++) {
            book = books.get(i);
            if (book.isAvailable())
                displayBook(books.get(i));
        }
    }

    private void displayBookHeader() {
        System.out.format("%-30s%-20s%-10s\n", "Title", "Author", "YearOfPublish");
    }

    public String getUserInput() {
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        String inputFromConsole = "";
        try {
            inputFromConsole = input.readLine();
        }
        catch (IOException ex) {

        }
        return inputFromConsole;
    }

    public void outputConsole(String string) {
        System.out.println(string);
    }

    public void displayCheckOutStatus(Book book) {
        if (book != null)
            System.out.println("Thank you! Enjoy the book");
        else
            System.out.println("That book is not available");
    }

    public void displayCheckInStatus(Book book) {
        if (book != null)
            System.out.println("Thank you for returning the book");
        else
            System.out.println("That is not a valid book to return");
    }

    public void displayMovieCheckOutStatus(Movie movie) {
        if (movie != null)
            System.out.println("Thank you! Enjoy the movie");
        else
            System.out.println("That movie is not available");
    }

    public void displayCheckOutMoviesList(ArrayList<Movie> checkedOutBooks) {
        System.out.format("%-30s%-20s%-10s%-10s\n", "Title", "Director", "YearOfPublish", "Rating");
        for (Movie movie : checkedOutBooks) {
            System.out.println(movie.toString());
        }
    }

    public void displayCheckInMoviesStatus(Movie movie) {
        if (movie != null)
            System.out.println("Thank you for returning the movie");
        else
            System.out.println("That is not a valid movie to return");
    }
}
