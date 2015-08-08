package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class LoginTest {
    ArrayList<User> users;
    User user1, user2;
    Login login;

    @Before
    public void setUp() {
        users = new ArrayList<User>();
        user1 = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        user2 = new User("name2", "user2@gmail.com", "0987654321", "001-0001", "54321", "user");
        users.add(user1);
        users.add(user2);
        login = new Login(users);
    }

    @Test
    public void shouldKnowsHowToAuthenticateUserWhenWrongLibraryNumberAndPasswordGiven() {
        assertEquals(null, login.authenticate("000-0001", "123"));
    }

    @Test
    public void shouldKnowsHowToAuthenticateUserWithLibraryNumberAndPassword() {
        assertEquals(user1, login.authenticate("000-0001", "12345"));
    }
}