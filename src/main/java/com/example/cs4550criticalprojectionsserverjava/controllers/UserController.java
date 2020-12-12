package com.example.cs4550criticalprojectionsserverjava.controllers;

import com.example.cs4550criticalprojectionsserverjava.models.User;
import com.example.cs4550criticalprojectionsserverjava.models.UserResponse;
import com.example.cs4550criticalprojectionsserverjava.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    UserService service = new UserService();

    @GetMapping("api/users/{username}/{password}")
    public UserResponse getUserByLogin(@PathVariable("username") String username,
                                       @PathVariable("password") String password) {
        return service.getUserByLogin(username, password);
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
    public User getUserByName(
            @PathVariable("username") String username) {
        return service.getUserByName(username);
    }

    @GetMapping("/api/users/{uid}")
    public User getUserById(
            @PathVariable("uid") Integer id) {
        return service.getUserById(id);
    }

    @PostMapping("/api/users")
    public User createUser(
            @RequestBody User user) {
        return service.createUser(user);
    }

    @DeleteMapping("/api/users/{username}")
    public Integer deleteUser(
            @PathVariable("username") String username) {
        return service.deleteUser(username);
    }

    @PutMapping("/api/users/{username}")
    public Integer updateUser(
            @PathVariable("username") String username,
            @RequestBody User newUser) {
        return service.updateUser(username, newUser);
    }
}
