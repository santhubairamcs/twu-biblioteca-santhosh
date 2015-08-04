package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void shouldKnowsHowToAuthenticateUserWhenWrongLibraryNumberAndPasswordGiven() {
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345");
        User user2 = new User("name2", "user2@gmail.com", "0987654321", "001-0001", "54321");
        users.add(user1);
        users.add(user2);
        Login login = new Login(users);

        assertEquals(null, login.authenticate("000-0001", "123"));
    }

    @Test
    public void shouldKnowsHowToAuthenticateUserWithLibraryNumberAndPassword() {
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345");
        User user2 = new User("name2", "user2@gmail.com", "0987654321", "001-0001", "54321");
        users.add(user1);
        users.add(user2);
        Login login = new Login(users);

        assertEquals(user1, login.authenticate("000-0001", "12345"));
    }
}