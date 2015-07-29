package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    View view ;
    Library library;
    ArrayList<String[]> books;

    public BibliotecaApp(View view, ArrayList<String[]> books){
        this.view = view;
        this.books = books;
        library = new Library(books);
    }

    public void start(boolean runUntilQuit) {
        view.greetUser();
        menuLoop(runUntilQuit);
    }

    private void menuLoop(boolean run) {
        while (run) {
            view.outputConsole("Choose option\nListBooks");
            String userChoice = view.getUserInput();
            if (userChoice.equals("ListBooks"))
                view.listBooks(library.getBooks());
            else
                view.outputConsole("Select a valid option!\n");
        }
    }
}