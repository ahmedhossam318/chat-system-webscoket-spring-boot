package com.socket_pro.storage;

import com.sun.source.tree.UsesTree;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {
    private static UserStorage instance;
    private Set<String> users;

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(String userName)throws Exception{
        if (users.contains(userName))
        {
             throw new Exception ("user already exist with username: " + userName);
        }
         users.add(userName);
    }

    private UserStorage()
    {
        users = new HashSet<>();
    }


    public static void setInstance(UserStorage instance) {
        UserStorage.instance = instance;
    }
    public static synchronized UserStorage getInstaance()
    {
        if (instance == null)
            instance = new UserStorage();
        return instance;
    }
}
