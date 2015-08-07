package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class UserTest {

    @Test
    public void shouldKnowsHowToAuthenticateUserWithGivenLibraryNumberAndPassword() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");

        assertEquals(true, user.authenticate("000-0001", "12345"));
    }

    @Test
    public void shouldKnowsHowToAuthenticateUserWithGivenWrongLibraryNumberOrPasswordOrBoth() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");

        assertEquals(false, user.authenticate("000-0001", "1234"));
    }

    @Test
    public void shouldKnowsHowToCompareTwoSameUsers() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");

        assertEquals(true, user.equals(user));
    }

    @Test
    public void shouldKnowsHowToCompareTwoDifferentUsers() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        User user1 = new User("name2", "user2@gmail.com", "12", "000-0001", "12345", "librarian");

        assertEquals(false, user.equals(user1));
    }
}