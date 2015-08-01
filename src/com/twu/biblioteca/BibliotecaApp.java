package com.twu.biblioteca;


public class BibliotecaApp {
    View view ;
    Library library;
    public BibliotecaApp(View view, Library library){
        this.view = view;
        this.library = library;
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
            else
                view.outputConsole("Select a valid option!");
        }
    }
}