package com.twu.biblioteca.controller;


import com.twu.biblioteca.model.BookSection;
import com.twu.biblioteca.model.MovieSection;
import com.twu.biblioteca.view.View;

public class BibliotecaApp {
    View view ;
    BookSection bookSection;
    MovieSection movieSection;
    public BibliotecaApp(View view, BookSection bookSection, MovieSection movieSection){
        this.view = view;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
    }

    public void start(boolean runUntilQuit) {
        view.greetUser();
        menuLoop(runUntilQuit);
    }

    private void menuLoop(boolean runUntilQuit) {
        while (runUntilQuit) {
            view.outputConsole("\nChoose option\n\t1.ListBooks\n\t2.CheckOut Book\n\t3.CheckIn Book\n\t4.List CheckOut Books\n" +
                    "\t5.List Movies\n\t6.CheckOut Movie\n\t7.CheckIn Movie\n\t8.List Checked Movies\n\t9.Quit\n");
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
                view.listBooks(bookSection.getCheckedOutBooks());
            }
            else if (userChoice.equals("5")) {
                view.displayCheckOutMoviesList(movieSection.getMovies());
            }
            else if (userChoice.equals("6")) {
                view.outputConsole("Enter movie name: ");
                String movie = view.getUserInput();
                view.displayMovieCheckOutStatus(movieSection.checkout(movie));
            }
            else if (userChoice.equals("7")) {
                view.outputConsole("Enter movie name: ");
                String movie = view.getUserInput();
                view.displayCheckInMoviesStatus(movieSection.checkin(movie));
            }
            else if (userChoice.equals("8")) {
                view.displayCheckOutMoviesList(movieSection.getCheckedOutMovies());
            }
            else if (userChoice.equals("9")) {
                System.exit(0);
            }
            else
                view.outputConsole("Select a valid option!");
        }
    }
}