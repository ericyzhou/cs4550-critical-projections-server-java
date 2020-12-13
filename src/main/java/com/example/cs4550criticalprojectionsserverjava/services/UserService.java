package com.example.cs4550criticalprojectionsserverjava.services;

import com.example.cs4550criticalprojectionsserverjava.models.User;
import com.example.cs4550criticalprojectionsserverjava.models.UserResponse;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class UserService {
    List<User> users = new ArrayList<>();

    {
        users.add(new User(-1, "user1", "password1", "user1@email.com", "Admin", "https://pbs.twimg.com/profile_images/2205628019/ny2hc_400x400.png"));
        users.add(new User(-2, "user2", "password2", "user2@email.com", "User", "https://images.uncyclomedia.co/uncyclopedia/en/7/77/Bilbobag.jpg"));
        users.add(new User(-3, "user3", "password3", "user3@email.com", "Reviewer", "https://upload.wikimedia.org/wikipedia/commons/b/b6/Queen_Elizabeth_II_in_March_2015.jpg"));
        users.add(new User(-4, "user4", "password4", "user4@email.com", "Reviewer", "https://www.courant.com/resizer/D9qmAnzR8PY5q-GBdUBBVuNVUTs=/415x311/top/arc-anglerfish-arc2-prod-tronc.s3.amazonaws.com/public/NTWCZKYTDJBI7CASRJ32F2RN6E.jpg"));
    }

    public UserResponse usernameIsValid(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return new UserResponse(0);
            }
        }
        return new UserResponse(1);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public UserResponse getUserByName(String username) {
        User tempUser = new User();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                tempUser = new User(user);
                tempUser.setPassword("");
                return new UserResponse(1, tempUser);
            }
        }
        return new UserResponse(0, null);
    }

    public User getUserById(Integer id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public UserResponse getUserByLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return new UserResponse(1, user);
            }
        }
        return new UserResponse(0, null);
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
