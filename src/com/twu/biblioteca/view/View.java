package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import static com.twu.biblioteca.view.Messages.*;

public class View {

    public void greetUser() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void listBooks(ArrayList<Book> books) {
        displayBookHeader();
        for (Book book : books)
            System.out.println(book);
    }

    private void displayBookHeader() {
        System.out.println(BOOK_HEADER);
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
            System.out.println(BOOK_CHECKOUT_SUCCESSFUL);
        else
            System.out.println(BOOK_CHECKOUT_UNSUCCESSFUL);
    }

    public void displayCheckInStatus(Book book) {
        if (book != null)
            System.out.println(BOOK_CHECKIN_SUCCESSFUL);
        else
            System.out.println(BOOK_CHECKIN_UNSUCCESSFUL);
    }

    public void displayMovieCheckOutStatus(Movie movie) {
        if (movie != null)
            System.out.println(MOVIE_CHECKOUT_SUCCESSFUL);
        else
            System.out.println(MOVIE_CHECKOUT_UNSUCCESSFUL);
    }

    public void displayCheckedMovies(HashMap<Movie, User> checkedOutBooks) {
        System.out.println(CHECKOUT_MOVIE_HEADER);
        for (Movie movie : checkedOutBooks.keySet()) {
            System.out.format(CHECKOUT_MOVIE_FORMAT, movie.getTitle(), checkedOutBooks.get(movie));
        }
    }

    public void displayCheckInMoviesStatus(Movie movie) {
        if (movie != null)
            System.out.println(MOVIE_CHECKIN_SUCCESSFUL);
        else
            System.out.println(MOVIE_CHECKIN_UNSUCCESSFUL);
    }

    public void displayUserProfile(String userProfile) {
        System.out.println(USER_DETAILS_HEADER);
        System.out.println(userProfile);
    }

    public void displayCheckedBooks(HashMap<Book, User> checkedOutBooks) {
        System.out.println(CHECKOUT_BOOK_HEADER);
        for (Book book : checkedOutBooks.keySet()) {
            System.out.format("%-25s%-75s\n", book.getTitle(), checkedOutBooks.get(book));
        }
    }

    public void displayMoviesList(ArrayList<Movie> movies) {
        System.out.println(MOVIE_HEADER);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public int showMenu(String userRole) {
        int indexOfMenuItem = 7;
        outputConsole("\nChoose option\n\t1.ListBooks\n\t2.CheckOut Book\n\t3.CheckIn Book\n\t4.List Movies\n\t5.CheckOut Movie\n\t6.CheckIn Movie");
        if ("librarian".equals(userRole)) {
            outputConsole("\t7.List CheckedOut Books\n\t8.List CheckedOut Movies");
            indexOfMenuItem = 9;
        }
        outputConsole("\t" + indexOfMenuItem + ".Profile\n\t" + (++indexOfMenuItem) + ".Logout");
        return indexOfMenuItem;
    }
}
