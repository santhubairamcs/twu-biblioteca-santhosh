package com.twu.biblioteca;

import java.util.ArrayList;


public class BibliotecaApp {
    View view ;
    Library library;
    ArrayList<Book> books;
    CheckOut checkout;
    CheckIn checkin;
    public BibliotecaApp(View view, ArrayList<Book> books){
        this.view = view;
        this.books = books;
        library = new Library(books);
        checkout = new CheckOut(library);
        checkin = new CheckIn(library);
    }

    public void start(boolean runUntilQuit) {
        view.greetUser();
        menuLoop(runUntilQuit);
    }

    private void menuLoop(boolean runUntilQuit) {
        while (runUntilQuit) {
            view.outputConsole("\nChoose option\n\tListBooks\n\tCheckOut\n\tCheckIn\n\tQuit");
            String userChoice = view.getUserInput();
            if (userChoice.equals("ListBooks"))
                view.listBooks(library.getBooks());
            else if (userChoice.equals("Quit"))
                System.exit(0);
            else if(userChoice.equals("CheckOut"))
                view.displayBook(checkout.checkOut(view.getUserInput()));
            else if (userChoice.equals("CheckIn"))
                view.displayBook(checkin.checkIn(view.getUserInput()));
            else
                view.outputConsole("Select a valid option!");
        }
    }
}