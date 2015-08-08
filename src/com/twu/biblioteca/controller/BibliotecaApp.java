package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Login;
import com.twu.biblioteca.model.User;
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

    public BibliotecaApp(View view, BookSection bookSection, MovieSection movieSection, Login login){
        this.view = view;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.login = login;
    }

    public void start() {
        while (true)
            userLogin();
    }

    public void userLogin() {
            view.greetUser();
            view.outputConsole("Choose\n\t1.Login\n\t2.Quit\n");
            view.outputConsole("Enter your choice: ");
            String userChoice = view.getUserInput();
            if (userChoice.equals("1")) {
                view.outputConsole("Enter Library Number: ");
                String libraryNumber = view.getUserInput();
                view.outputConsole("Enter password: ");
                String password = view.getUserInput();
                user = login.authenticate(libraryNumber, password);
                if (user != null)
                    mainMenuHandler(user);
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

    private void mainMenuHandler(User user) {
        String userChoice;
        do {
            int indexOfMenuItem = view.showMenu(user.getRole());
            userChoice = view.getUserInput();
            dispatcher(user, userChoice);
        } while (!userChoice.equals("0"));
    }

    public void dispatcher(User user, String userChoice) {
        int indexOfMenuItem = 7;
        if (userChoice.equals("1")) {
            view.listBooks(bookSection.getBooks());
        }
        else if(userChoice.equals("2")) {
            view.outputConsole("Enter book name: ");
            String bookTitle = view.getUserInput();
            Book book = bookSection.checkOut(bookTitle, user);
            view.displayCheckOutStatus(book);
        }
        else if (userChoice.equals("3")) {
            view.outputConsole("Enter book name: ");
            String book = view.getUserInput();
            view.displayCheckInStatus(bookSection.checkIn(book, user));
        }
        else if (userChoice.equals("4")) {
            view.displayMoviesList(movieSection.getMovies());
        }
        else if (userChoice.equals("5")) {
            view.outputConsole("Enter movie name: ");
            String movieTitle = view.getUserInput();
            Movie movie = movieSection.checkOut(movieTitle, user);
            view.displayMovieCheckOutStatus(movie);
        }
        else if (userChoice.equals("6")) {
            view.outputConsole("Enter movie name: ");
            String movie = view.getUserInput();
            view.displayCheckInMoviesStatus(movieSection.checkIn(movie, user));
        }
        else if (userChoice.equals("7") && "librarian".equals(user.getRole())) {
            view.displayCheckedBooks(bookSection.getCheckedOutBooks());
        }
        else if (userChoice.equals("8") && "librarian".equals(user.getRole())) {
            view.displayCheckedMoviesList(movieSection.getCheckedOutMovies());
        }
        else if (userChoice.equals((indexOfMenuItem - 1) + "")) {

            view.displayUserProfile(user.toString());
        }
        else if (userChoice.equals(indexOfMenuItem + "")) {
            userLogin();
        }
        else
            view.outputConsole("Select a valid option!");
    }
}
