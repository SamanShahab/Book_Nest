//UserRepository.java
package com.OOP.project.Book_Nest.repository;

import com.OOP.project.Book_Nest.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private Map<String, User> userDatabase = new HashMap<>(); // In-memory database

    // Find user by userId
    public Optional<User> findByUserId(String userId) {
        return Optional.ofNullable(userDatabase.get(userId)); // Return user if exists
    }

    // Save user in the in-memory "database"
    public void save(User user) {
        userDatabase.put(user.getUserId(), user); // Save user with userId as key
    }
}
