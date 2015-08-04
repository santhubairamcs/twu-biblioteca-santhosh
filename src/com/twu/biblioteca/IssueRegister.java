package com.twu.biblioteca;

import java.util.HashMap;

public class IssueRegister {
    HashMap<User, String> issueRegister = new HashMap<User, String>();

    public User addEntry(User user, String itemName) {
        issueRegister.put(user, itemName);
        return user;
    }
}
