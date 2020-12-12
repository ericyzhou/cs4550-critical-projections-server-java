package com.example.cs4550criticalprojectionsserverjava.services;

import com.example.cs4550criticalprojectionsserverjava.models.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class UserService {
    List<User> users = new ArrayList<>();

    {
        users.add(new User(1, "user1", "password1", "user1@email.com", "Admin"));
        users.add(new User(2, "user2", "password2", "user2@email.com", "User"));
        users.add(new User(3, "user3", "password3", "user3@email.com", "Reviewer"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserByName(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User createUser(User newUser) {
        Integer newId = (new Random()).nextInt(Integer.MAX_VALUE);
        newUser.setId(newId);
        users.add(newUser);
        return newUser;
    }

    public Integer deleteUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                return 1;
            }
        }
        return 0;
    }

    public Integer updateUser(String username, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                users.set(i, user);
                return 1;
            }
        }
        return 0;
    }
}
