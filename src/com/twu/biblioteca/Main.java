package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaApp;
import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.View;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("11111", "A Suitable Boy", "Vikram Seth ", 1993, true);
        Book book2 = new Book("22222", "Cutting For Stone", "Abraham Verghese", 2009, true);
        Book book3 = new Book("33333","The White Tiger", "Aravind Adiga", 2008, true);
        Book book4 = new Book("44444","Train to Pakistan", "Khushwant Singh", 1956, true);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        View view = new View();
        BookSection bookSection = new BookSection(books);
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        Movie movie1 = new Movie("bahubali", "rajamouli", 2015, 9, true);
        Movie movie2 = new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9, true);
        availableMovies.add(movie1);
        availableMovies.add(movie2);
        MovieSection movieSection = new MovieSection(availableMovies);
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        User user2 = new User("name2", "user2@gmail.com", "0987654321", "001-0001", "12345", "user");
        users.add(user1);
        users.add(user2);
        Login login = new Login(users);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(view , bookSection, movieSection, login);
        bibliotecaApp.start();
    }
}
