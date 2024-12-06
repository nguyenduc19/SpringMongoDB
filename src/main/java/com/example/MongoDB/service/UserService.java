package com.example.MongoDB.service;

import com.example.MongoDB.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserByUsername(String userName);

    public User addUser(User user);

    public User updateUser(String userName, User user);

    public void deleteUser(String userName);
}
