package com.twu.biblioteca.controller;

import com.twu.biblioteca.Login;
import com.twu.biblioteca.User;
import com.twu.biblioteca.model.BookSection;
import com.twu.biblioteca.model.MovieSection;
import com.twu.biblioteca.view.View;


public class BibliotecaApp {
    View view ;
    BookSection bookSection;
    MovieSection movieSection;
    Login login;
    User user;

    public BibliotecaApp(View view, BookSection bookSection, MovieSection movieSection, Login login){
        this.view = view;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.login = login;
    }

    public void start(boolean runUntilQuit) {
        view.greetUser();
        view.outputConsole("Enter Library Number: ");
        String libraryNumber = view.getUserInput();
        view.outputConsole("Enter password: ");
        String password = view.getUserInput();
        user = login.authenticate("001-0001", "12345");
        if (user != null)
            menuLoop(runUntilQuit);
    }

    private void menuLoop(boolean runUntilQuit) {
        while (runUntilQuit) {
            view.outputConsole("\nChoose option\n\t1.ListBooks\n\t2.CheckOut Book\n\t3.CheckIn Book\n\t4.List Movies\n\t5.CheckOut Movie\n\t6.CheckIn Movie");
            if ("librarian".equals(user.getRole()))
                view.outputConsole("\t7.List CheckedOut Books\n\t8.List CheckedOut Movies\n\tQuit");
            view.outputConsole("\tQuit");
            view.outputConsole("Enter your choice: ");
            String userChoice = view.getUserInput();
            if (userChoice.equals("1")) {
                view.listBooks(bookSection.getBooks());
            }
            else if(userChoice.equals("2")) {
                view.outputConsole("Enter book name: ");
                String book = view.getUserInput();
                view.displayCheckOutStatus(bookSection.checkOut(book));
            }
            else if (userChoice.equals("3")) {
                view.outputConsole("Enter book name: ");
                String book = view.getUserInput();
                view.displayCheckInStatus(bookSection.checkIn(book));
            }
            else if (userChoice.equals("4")) {
                view.displayCheckOutMoviesList(movieSection.getMovies());
            }
            else if (userChoice.equals("5")) {
                view.outputConsole("Enter movie name: ");
                String movie = view.getUserInput();
                view.displayMovieCheckOutStatus(movieSection.checkout(movie));
            }
            else if (userChoice.equals("6")) {
                view.outputConsole("Enter movie name: ");
                String movie = view.getUserInput();
                view.displayCheckInMoviesStatus(movieSection.checkin(movie));
            }
            else if (userChoice.equals("7") && "librarian".equals(user.getRole())) {
                view.listBooks(bookSection.getCheckedOutBooks());
            }
            else if (userChoice.equals("8") && "librarian".equals(user.getRole())) {
                view.displayCheckOutMoviesList(movieSection.getCheckedOutMovies());
            }
            else if (userChoice.equals("Quit")) {
                System.exit(0);
            }
            else
                view.outputConsole("Select a valid option!");
        }
    }
}