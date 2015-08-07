package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


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

    public void displayCheckedMoviesList(HashMap<Movie, User> checkedOutBooks) {
        System.out.format("%-30s%-25s%-25s%-25s\n", "Movie Title", "Customer Name", "Email", "Phone number");
        for (Movie movie : checkedOutBooks.keySet()) {
            System.out.format("%-30s%-100s\n",movie.getTitle(), checkedOutBooks.get(movie));
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

    public void displayCheckedBooks(HashMap<Book, User> checkedOutBooks) {
        System.out.format("%-25s%-25s%-25s%-25s\n", "Book Title", "Customer Name", "Email", "Phone number");
        for (Book book : checkedOutBooks.keySet()) {
            System.out.format("%-25s%-75s\n", book.getTitle(), checkedOutBooks.get(book));
        }
    }

    public void displayMoviesList(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
