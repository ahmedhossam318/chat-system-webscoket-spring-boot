package com.socket_pro.controller;

import com.socket_pro.storage.UserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

public class UsersController {
    @GetMapping("/registration/{username}")
    public ResponseEntity<Void> register(@PathVariable String userName )
    {
        System.out.println("Handling register user request " + userName);
        try {
            UserStorage.getInstaance().setUsers(userName);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/fetchall")
    public Set<String> getAllUsers()
    {
        return UserStorage.getInstaance().getUsers();
    }
}
