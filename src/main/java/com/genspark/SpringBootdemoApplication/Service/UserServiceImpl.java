package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Dao.UserDeo;
import com.genspark.SpringBootdemoApplication.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDeo userDeo;

    @Autowired
    public PasswordEncoder passwordEncoder;

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
    public User getUserByUsername(String username){
        if(userDeo.findByUsername(username)==null){
            return new User();
        }
        return userDeo.findByUsername(username);
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userDeo.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userFound = null;
        List<User> list = this.userDeo.findAll();

        for(int i=0;i<list.size();i++){
            if(list.get(i).getUsername().equals(user.getUsername())){
                userFound=list.get(i);
            }
        }
        if(userFound==null){
            throw new RuntimeException("Username not found for username :: " + user.getUsername());
        }

        userFound.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userDeo.save(user);
    }

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
