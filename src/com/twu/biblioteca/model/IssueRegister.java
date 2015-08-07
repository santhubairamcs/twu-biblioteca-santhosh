package com.twu.biblioteca.model;

import java.util.HashMap;

public class IssueRegister {
    HashMap<String, User> issueRegister = new HashMap<String, User>();

    public User addEntry(String itemName, User user) {
        issueRegister.put(itemName, user);
        return user;
    }

    public boolean checkEntry(String checkItem, User userThat) {
        for (String itemName : issueRegister.keySet()) {
            if ( itemName.equals(checkItem) && userThat.equals(issueRegister.get(itemName)) ) {
                return true;
            }
        }
        return false;
    }
}