package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(int userID);
    User getUserByUsername(String username);
    User addUser(User user);
    User updateUser(User user);
    String disableUserById(int userID);
    String deleteUserById(int clientID);
}
