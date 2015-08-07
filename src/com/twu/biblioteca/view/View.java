package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class View {

    public void greetUser() {
        System.out.println("Welcome to Biblioteca");
    }

    public void displayBook(Book book) {
        System.out.format("%-25s%-25s%-25s\n", book.getTitle(), book.getAuthor(), book.getYearOfPublish());
    }

    public void listBooks(ArrayList<Book> books) {
        displayBookHeader();
        for (Book book : books)
            displayBook(book);
    }

    private void displayBookHeader() {
        System.out.format("%-25s%-25s%-25s\n", "Title", "Author", "YearOfPublish");
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
        System.out.format("%-25s%-25s%-25s%-25s\n", "Title", "Director", "YearOfPublish", "Rating");
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

    public void displayUserProfile(String userProfile) {
        System.out.format("%-25s%-25s%-25s\n", "User Name", "Email", "Mobile Number");
        System.out.println(userProfile);
    }
}
