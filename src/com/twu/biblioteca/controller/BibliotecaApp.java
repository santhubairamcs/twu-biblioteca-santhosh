package com.twu.biblioteca.controller;

import com.twu.biblioteca.IssueRegister;
import com.twu.biblioteca.Login;
import com.twu.biblioteca.User;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.BookSection;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.MovieSection;
import com.twu.biblioteca.view.View;


public class BibliotecaApp {
    View view ;
    BookSection bookSection;
    MovieSection movieSection;
    Login login;
    User user;
    IssueRegister issueRegister = new IssueRegister();

    public BibliotecaApp(View view, BookSection bookSection, MovieSection movieSection, Login login){
        this.view = view;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.login = login;
    }

    public void start(boolean runUntilQuit) {
        userLogin(runUntilQuit);
    }

    private void userLogin(boolean runUntilQuit) {
        while (true) {
            view.greetUser();
            view.outputConsole("Choose\n\t1.Login\n\t2.Quit");
            String userChoice = view.getUserInput();
            if (userChoice.equals("1")) {
                view.outputConsole("Enter Library Number: ");
                String libraryNumber = view.getUserInput();
                view.outputConsole("Enter password: ");
                String password = view.getUserInput();
                user = login.authenticate(libraryNumber, password);
                if (user != null)
                    menuLoop(runUntilQuit);
                else
                    view.outputConsole("Invalid login, Try again");
            }
            else if (userChoice.equals("2")) {
                System.exit(0);
            }
            else {
                view.outputConsole("Select a valid option!");
            }
        }
    }

    private void menuLoop(boolean runUntilQuit) {
        while (runUntilQuit) {
            int indexOfMenuItem;
            view.outputConsole("\nChoose option\n\t1.ListBooks\n\t2.CheckOut Book\n\t3.CheckIn Book\n\t4.List Movies\n\t5.CheckOut Movie\n\t6.CheckIn Movie");
            indexOfMenuItem = 7;
            if ("librarian".equals(user.getRole())) {
                view.outputConsole("\t7.List CheckedOut Books\n\t8.List CheckedOut Movies");
                indexOfMenuItem = 9;
            }
            view.outputConsole("\t" + indexOfMenuItem + ".Profile\n\t" + (++indexOfMenuItem) + ".Logout");
            view.outputConsole("Enter your choice: ");
            String userChoice = view.getUserInput();
            if (userChoice.equals("1")) {
                view.listBooks(bookSection.getBooks());
            }
            else if(userChoice.equals("2")) {
                view.outputConsole("Enter book name: ");
                String bookTitle = view.getUserInput();
                Book book = bookSection.checkOut(bookTitle);
                if (book != null)
                    issueRegister.addEntry(bookTitle, user);
                view.displayCheckOutStatus(book);
            }
            else if (userChoice.equals("3")) {
                view.outputConsole("Enter book name: ");
                String book = view.getUserInput();
                if (issueRegister.checkEntry(book, user))
                    view.displayCheckInStatus(bookSection.checkIn(book));
                else
                    view.outputConsole("You are not authorised to checkin this book");
            }
            else if (userChoice.equals("4")) {
                view.displayCheckOutMoviesList(movieSection.getMovies());
            }
            else if (userChoice.equals("5")) {
                view.outputConsole("Enter movie name: ");
                String movieTitle = view.getUserInput();
                Movie movie = movieSection.checkout(movieTitle);
                if (movie != null)
                    issueRegister.addEntry(movieTitle, user);
                view.displayMovieCheckOutStatus(movie);
            }
            else if (userChoice.equals("6")) {
                view.outputConsole("Enter movie name: ");
                String movie = view.getUserInput();
                if (issueRegister.checkEntry(movie, user))
                    view.displayCheckInMoviesStatus(movieSection.checkin(movie));
                else
                    view.outputConsole("You are not authorised to checkin this movie");
            }
            else if (userChoice.equals("7") && "librarian".equals(user.getRole())) {
                view.listBooks(bookSection.getCheckedOutBooks());
            }
            else if (userChoice.equals("8") && "librarian".equals(user.getRole())) {
                view.displayCheckOutMoviesList(movieSection.getCheckedOutMovies());
            }
            else if (userChoice.equals((indexOfMenuItem - 1) + "")) {
                view.outputConsole(user.toString());
            }
            else if (userChoice.equals(indexOfMenuItem + "")) {
                break;
            }
            else
                view.outputConsole("Select a valid option!");
        }
    }
}