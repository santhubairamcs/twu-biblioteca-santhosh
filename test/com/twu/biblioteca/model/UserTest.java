package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserTest {
    private User user;
    private User user1;

    @Before
    public void setUp() {
        user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        user1 = new User("name2", "user2@gmail.com", "12", "000-0001", "12345", "librarian");
    }

    @Test
    public void shouldKnowsHowToAuthenticateUserWithGivenLibraryNumberAndPassword() {
        assertEquals(true, user.authenticate("000-0001", "12345"));
    }

    @Test
    public void shouldKnowsHowToAuthenticateUserWithGivenWrongLibraryNumberOrPasswordOrBoth() {
        assertEquals(false, user.authenticate("000-0001", "1234"));
    }

    @Test
    public void shouldKnowsHowToCompareTwoSameUsers() {
        assertEquals(true, user.equals(user));
    }

    @Test
    public void shouldKnowsHowToCompareTwoDifferentUsers() {
        assertEquals(false, user.equals(user1));
    }
}