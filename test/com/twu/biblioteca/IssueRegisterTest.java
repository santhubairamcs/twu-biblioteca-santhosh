package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class IssueRegisterTest {

    @Test
    public void shouldKnowsHowToAddEntriesToIssueRegister() {
        User user = new User("name1", "user1@gmail.com", "1234567890", "000-0001", "12345", "librarian");
        IssueRegister issueRegister = new IssueRegister();

        assertEquals(user, issueRegister.addEntry(user, "Train to Pakistan"));
    }

}