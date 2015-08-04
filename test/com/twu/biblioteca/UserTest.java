package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;


public class UserTest {

    @Test
    public void shouldKnowsHowToAuthenticateUserWithGivenLibraryNumberAndPassword() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345");

        assertEquals(true, user.authenticate("000-0001", "12345"));
    }

}