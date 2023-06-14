package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Dao.UserDeo;
import com.genspark.SpringBootdemoApplication.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDeo userDeo;

    @Override
    public List<User> getAllUsers() {return this.userDeo.findAll();}

    @Override
    public User getUserById(int userID) {
        Optional <User> u = this.userDeo.findById(userID);
        User user = null;
        if (u.isPresent()){
            user = u.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + userID);
        }
        return user;
    }

    @Override
    public User addUser(User user) {return this.userDeo.save(user);}

    @Override
    public User updateUser(User user) {return this.userDeo.save(user);}

    @Override
    public String deleteUserById(int userID) {
        Optional <User> u = this.userDeo.findById(userID);
        User user = null;
        if (u.isPresent()){
            user = u.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + userID);
        }
        user.setDisabled(true);
        user.setRemoved_at(new Date());
        this.userDeo.save(user);
        return "Removed Successfully";
    }
}
