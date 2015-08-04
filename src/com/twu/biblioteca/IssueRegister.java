package com.twu.biblioteca;

import java.util.HashMap;

public class IssueRegister {
    HashMap<User, String> issueRegister = new HashMap<User, String>();

    public User addEntry(User user, String itemName) {
        issueRegister.put(user, itemName);
        return user;
    }

    public boolean checkEntry(User userThat,String bookTitle) {
        for (User user : issueRegister.keySet()) {
            if ( user.equals(userThat) && bookTitle.equals(issueRegister.get(user)) ) {
                return true;
            }
        }
        return false;
    }
}
