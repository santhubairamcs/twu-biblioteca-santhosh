package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    View view ;
    Library library;
    ArrayList<String[]> books;
    CheckOut checkout;

    public BibliotecaApp(View view, ArrayList<String[]> books){
        this.view = view;
        this.books = books;
        library = new Library(books);
        checkout = new CheckOut(library);
    }

    public void start(boolean runUntilQuit) {
        view.greetUser();
        menuLoop(runUntilQuit);
    }

    private void menuLoop(boolean runUntilQuit) {
        while (runUntilQuit) {
            view.outputConsole("\nChoose option\n\tListBooks\n\tCheckout\n\tQuit");
            String userChoice = view.getUserInput();
            if (userChoice.equals("ListBooks"))
                view.listBooks(library.getBooks());
            else if (userChoice.equals("Quit"))
                System.exit(0);
            else if(userChoice.equals("Checkout"))
                checkout.checkOut(view.getUserInput());
            else
                view.outputConsole("Select a valid option!");
        }
    }
}