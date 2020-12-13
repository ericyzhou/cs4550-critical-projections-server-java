package com.example.cs4550criticalprojectionsserverjava.controllers;

import com.example.cs4550criticalprojectionsserverjava.models.Login;
import com.example.cs4550criticalprojectionsserverjava.models.User;
import com.example.cs4550criticalprojectionsserverjava.models.UserResponse;
import com.example.cs4550criticalprojectionsserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("api/login")
    public UserResponse getUserByLogin(
            @RequestBody Login login) {
        return service.getUserByLogin(login);
    }

    @GetMapping("api/validate/{username}")
    public UserResponse usernameIsValid(
            @PathVariable("username") String username) {
        return service.usernameIsValid(username);
    }

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/api/users/{username}")
    public UserResponse getUserByName(
            @PathVariable("username") String username) {
        return service.getUserByName(username);
    }

    @GetMapping("/api/users/id/{uid}")
    public User getUserById(
            @PathVariable("uid") Integer id) {
        return service.getUserById(id);
    }

    @PostMapping("api/users")
    public User createUser(
            @RequestBody User user) {
        return service.createUser(user);
    }

    @DeleteMapping("/api/users/{uid}")
    public Integer deleteUser(
            @PathVariable("uid") Integer userId) {
        return service.deleteUser(userId);
    }

    @PutMapping("/api/users/{uid}")
    public User updateUser(
            @PathVariable("uid") Integer userId,
            @RequestBody User newUser) {
        return service.updateUser(userId, newUser);
    }
}
