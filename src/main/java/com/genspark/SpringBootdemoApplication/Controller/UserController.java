package com.genspark.SpringBootdemoApplication.Controller;

import com.genspark.SpringBootdemoApplication.Entity.User;
import com.genspark.SpringBootdemoApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/authentication")
    public boolean login(){
        return true;
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username){
        return this.userService.getUserByUsername(username);
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }
    @DeleteMapping("/users/{userID}")
    public String deleteUser(@PathVariable String userID){
        return this.userService.deleteUserById(Integer.parseInt(userID));
    }
}
