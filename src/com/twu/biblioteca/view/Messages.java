package com.twu.biblioteca.view;


public interface Messages {
    String WELCOME_MESSAGE = "Welcome to Bangalore Public Library";
    String BOOK_HEADER = String.format("%-25s%-25s%-25s", "Title", "Author", "YearOfPublish");
    String BOOK_CHECKOUT_SUCCESSFUL = "Thank you! Enjoy the book";
    String BOOK_CHECKOUT_UNSUCCESSFUL = "That book is not available";
    String BOOK_CHECKIN_SUCCESSFUL = "Thank you for returning the book";
    String BOOK_CHECKIN_UNSUCCESSFUL = "That is not a valid book to return";
    String MOVIE_CHECKOUT_SUCCESSFUL = "Thank you! Enjoy the movie";
    String MOVIE_CHECKOUT_UNSUCCESSFUL = "That movie is not available";
    String MOVIE_CHECKIN_SUCCESSFUL = "Thank you for returning the movie";
    String MOVIE_CHECKIN_UNSUCCESSFUL = "That is not a valid movie to return";
    String CHECKOUT_BOOK_HEADER = String.format("%-25s%-25s%-25s%-25s", "Book Title", "Customer Name", "Email", "Phone number");
    String CHECKOUT_MOVIE_HEADER = String.format("%-25s%-25s%-25s%-25s", "Movie Title", "Customer Name", "Email", "Phone number");
    String CHECKOUT_MOVIE_FORMAT = "%-25s%-100s";
    String USER_DETAILS_HEADER = String.format("%-25s%-25s%-25s", "User Name", "Email", "Mobile Number");

    String MOVIE_HEADER = String.format("%-25s%-25s%-25s%-25s", "Movie Title", "Director", "Year Of Release", "Rating");

    String INVALID_OPTION = "Select a valid option!";
    String BOOK_PROMPT = "Enter a book name: ";
    String MOVIE_PROMPT = "Enter a movie name: ";
    String LIBRARY_NUMBER_PROMPT = "Enter your library number: ";
    String PASSWORD_PROMPT = "Enter your password: ";
    String ENTER_YOUR_CHOICE = "Enter your choice: ";
    String INVALID_LOGIN = "Invalid login, Try again";
    String LOGIN_MENU = "Choose\n\t1.Login\n\t2.Quit\n";
}
