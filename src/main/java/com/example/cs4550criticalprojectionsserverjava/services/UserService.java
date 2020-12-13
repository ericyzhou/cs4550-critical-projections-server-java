package com.example.cs4550criticalprojectionsserverjava.services;

import com.example.cs4550criticalprojectionsserverjava.models.Login;
import com.example.cs4550criticalprojectionsserverjava.models.User;
import com.example.cs4550criticalprojectionsserverjava.models.UserResponse;
import com.example.cs4550criticalprojectionsserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
//    List<User> users = new ArrayList<>();
//
//    {
//        users.add(new User(-1, "user1", "password1", "user1@email.com", "Admin", "https://pbs.twimg.com/profile_images/2205628019/ny2hc_400x400.png"));
//        users.add(new User(-2, "user2", "password2", "user2@email.com", "User", "https://images.uncyclomedia.co/uncyclopedia/en/7/77/Bilbobag.jpg"));
//        users.add(new User(-3, "user3", "password3", "user3@email.com", "Reviewer", "https://upload.wikimedia.org/wikipedia/commons/b/b6/Queen_Elizabeth_II_in_March_2015.jpg"));
//        users.add(new User(-4, "user4", "password4", "user4@email.com", "Reviewer", "https://www.courant.com/resizer/D9qmAnzR8PY5q-GBdUBBVuNVUTs=/415x311/top/arc-anglerfish-arc2-prod-tronc.s3.amazonaws.com/public/NTWCZKYTDJBI7CASRJ32F2RN6E.jpg"));
//    }

    public UserResponse usernameIsValid(String username) {
        List<String> matches = this.userRepository.findMatchingUsernames(username);
        if (matches.size() == 0) {
            return new UserResponse(0);
        } else {
            return new UserResponse(1);
        }
    }

    public List<User> getAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public UserResponse getUserByName(String username) {
        List<User> matches = this.userRepository.findUserByUsername(username);
        if (matches.size() == 0) {
            return new UserResponse(0, null);
        } else {
            User tempUser = matches.get(0);
            tempUser.setPassword("");
            return new UserResponse(1, tempUser);
        }
    }

    public User getUserById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    public UserResponse getUserByLogin(Login login) {

        String username = login.getUsername();
        String password = login.getPassword();

        List<User> searchUser = this.userRepository.findUserByLogin(username, password);

        if (searchUser.size() == 0) {
            return new UserResponse(0, null);
        } else {
            User tempUser = searchUser.get(0);
            tempUser.setPassword("");
            return new UserResponse(1, tempUser);
        }
    }

    public User createUser(User newUser) {
        return this.userRepository.save(newUser);
    }

    public Integer deleteUser(Integer userId) {
        this.userRepository.deleteById(userId);
        return 1;
    }

    public User updateUser(Integer userId, User user) {
        User toChange = this.userRepository.findById(userId).get();
        toChange.setUsername(user.getUsername());
        toChange.setPassword(user.getPassword());
        toChange.setEmail(user.getEmail());
        toChange.setProfilePic(user.getProfilePic());
        toChange.setRole(user.getRole());
        return this.userRepository.save(toChange);
    }
}
