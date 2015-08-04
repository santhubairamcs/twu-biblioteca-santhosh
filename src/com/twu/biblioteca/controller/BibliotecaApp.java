package com.twu.biblioteca.controller;


import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.MovieSection;
import com.twu.biblioteca.view.View;

public class BibliotecaApp {
    View view ;
    Library library;
    MovieSection movieSection;
    public BibliotecaApp(View view, Library library, MovieSection movieSection){
        this.view = view;
        this.library = library;
        this.movieSection = movieSection;
    }

    public void start(boolean runUntilQuit) {
        view.greetUser();
        menuLoop(runUntilQuit);
    }

    private void menuLoop(boolean runUntilQuit) {
        while (runUntilQuit) {
            view.outputConsole("\nChoose option\n\t1.ListBooks\n\t2.CheckOut Book\n\t3.CheckIn Book\n\t4.List Movies\n\t5.CheckOut Movie\n\t6.CheckIn Movie\n" +
                    "\t7.List Checked Movies\n\t8.Quit\n");
            view.outputConsole("Enter your choice: ");
            String userChoice = view.getUserInput();
            if (userChoice.equals("1")) {
                view.listBooks(library.getBooks());
            }
            else if(userChoice.equals("2")) {
                view.outputConsole("Enter book name: ");
                String book = view.getUserInput();
                view.displayCheckOutStatus(library.checkOut(book));
            }
            else if (userChoice.equals("3")) {
                view.outputConsole("Enter book name: ");
                String book = view.getUserInput();
                view.displayCheckInStatus(library.checkIn(book));
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
            else if (userChoice.equals("7")) {
                view.displayCheckOutMoviesList(movieSection.getCheckedOutBooks());
            }
            else if (userChoice.equals("8")) {
                System.exit(0);
            }
            else
                view.outputConsole("Select a valid option!");
        }
    }
}