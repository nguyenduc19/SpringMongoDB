package com.example.MongoDB.controller;

import com.example.MongoDB.model.User;
import com.example.MongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String userName){
        User user = userService.getUserByUsername(userName);
        if(user != null){
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUser(@PathVariable String userName, @RequestBody User updateUser){
        User existingUser = userService.updateUser(userName, updateUser);
        if(existingUser != null){
            return ResponseEntity.ok(existingUser);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userName){
        User user = userService.getUserByUsername(userName);
        if(user != null){
            userService.deleteUser(userName);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
