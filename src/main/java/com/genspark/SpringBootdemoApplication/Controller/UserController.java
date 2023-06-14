package com.genspark.SpringBootdemoApplication.Controller;

import com.genspark.SpringBootdemoApplication.Entity.User;
import com.genspark.SpringBootdemoApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/auth")
    public boolean login(){
        return true;
    }
    @GetMapping
    public List<User> getUsers(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/{userID}")
    public User getUser(@PathVariable String userID){
        return this.userService.getUserById(Integer.parseInt(userID));
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
    @PutMapping
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }
    @DeleteMapping("/{userID}")
    public String deleteUser(@PathVariable String userID){
        return this.userService.deleteUserById(Integer.parseInt(userID));
    }
}
