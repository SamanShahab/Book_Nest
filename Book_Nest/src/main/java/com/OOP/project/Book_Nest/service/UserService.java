//UserService.java
package com.OOP.project.Book_Nest.service;

import com.OOP.project.Book_Nest.model.User;
import com.OOP.project.Book_Nest.repository.UserRepository;

import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository(); // Manually instantiate repository (no DB)
    }

    // Register user
    public String registerUser(String name, String userId) {
        Optional<User> existingUser = userRepository.findByUserId(userId);
        if (existingUser.isPresent()) {
            return "User ID already exists. Please try with a different ID.";
        }
        User newUser = new User(name, userId);
        userRepository.save(newUser);
        return "Registration successful!";
    }

    // Login user
    public String loginUser(String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        return user.map(value -> "Welcome back, " + value.getName() + "!")
                .orElse("User not found. Please register first.");
    }
}


