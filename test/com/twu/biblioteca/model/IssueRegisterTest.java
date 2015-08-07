package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class IssueRegisterTest {

    @Test
    public void shouldKnowsHowToAddEntriesToIssueRegister() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        IssueRegister issueRegister = new IssueRegister();

        assertEquals(user, issueRegister.addEntry("Train to Pakistan", user));
    }

    @Test
    public void shouldKnowsHowToCheckWhetherGivenUserHadTakenAnyLibraryItem() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        IssueRegister issueRegister = new IssueRegister();
        issueRegister.addEntry("Train to Pakistan", user);

        assertEquals(true, issueRegister.checkEntry("Train to Pakistan", user));
    }

    @Test
    public void shouldKnowsHowToCheckWhetherGivenUserHadTakenNotTheGivenLibraryItem() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        IssueRegister issueRegister = new IssueRegister();
        issueRegister.addEntry("Train to Pakistan", user);

        assertEquals(false, issueRegister.checkEntry("Train", user));
    }
}