package com.twu.biblioteca;


import java.util.ArrayList;

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
            view.outputConsole("\nChoose option\n\tListBooks\n\tCheckOut\n\tCheckIn\n\tQuit\n");
            view.outputConsole("Enter your choice: ");
            String userChoice = view.getUserInput();
            if (userChoice.equals("ListBooks")) {
                view.listBooks(library.getBooks());
            }
            else if (userChoice.equals("Quit")) {
                System.exit(0);
            }
            else if(userChoice.equals("CheckOut")) {
                view.outputConsole("Enter book name: ");
                String book = view.getUserInput();
                view.displayCheckOutStatus(library.checkOut(book));
            }
            else if (userChoice.equals("CheckIn")) {
                view.outputConsole("Enter book name: ");
                String book = view.getUserInput();
                view.displayCheckInStatus(library.checkIn(book));
            }
            else if (userChoice.equals("CheckOut Movie")) {
                view.outputConsole("Enter movie name: ");
                String movie = view.getUserInput();
                view.displayMovieCheckOutStatus(movieSection.checkout(movie));
            }
            else
                view.outputConsole("Select a valid option!");
        }
    }
}