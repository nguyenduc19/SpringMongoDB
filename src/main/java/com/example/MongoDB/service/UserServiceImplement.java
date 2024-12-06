package com.example.MongoDB.service;

import com.example.MongoDB.model.User;
import com.example.MongoDB.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService{

    private UserReponsitory userReponsitory;

    @Autowired
    public UserServiceImplement(UserReponsitory userReponsitory) {
        this.userReponsitory = userReponsitory;
    }

    @Override
    public List<User> getAllUsers() {
        return userReponsitory.findAll();
    }

    @Override
    public User getUserByUsername(String userName) {
        return userReponsitory.findByUsername(userName);
    }

    @Override
    public User addUser(User user) {
        return userReponsitory.save(user);
    }

    @Override
    public User updateUser(String userName, User user) {
        User existingUser = userReponsitory.findByUsername(userName);
        if(existingUser != null){
            existingUser.setPassWord(user.getPassWord());
            return userReponsitory.save(existingUser);
        }else {
            return null;
        }
    }

    @Override
    public void deleteUser(String userName) {
        User user = userReponsitory.findByUsername(userName);
        if(user != null){
            userReponsitory.delete(user);
        }
    }
}
