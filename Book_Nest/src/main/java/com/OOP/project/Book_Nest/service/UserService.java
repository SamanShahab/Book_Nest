////UserService.java
//package com.OOP.project.Book_Nest.service;
//
//import com.OOP.project.Book_Nest.model.User;
//import com.OOP.project.Book_Nest.repository.UserRepository;
//
//import java.util.Optional;
//
//public class UserService {
//
//    private UserRepository userRepository;
//
//    public UserService() {
//        userRepository = new UserRepository(); // Manually instantiate repository (no DB)
//    }
//
//    // Register user
//    public String registerUser(String name, String userId) {
//        Optional<User> existingUser = userRepository.findByUserId(userId);
//        if (existingUser.isPresent()) {
//            return "User ID already exists. Please try with a different ID.";
//        }
//        User newUser = new User(name, userId);
//        userRepository.save(newUser);
//        return "Registration successful!";
//    }
//
//    // Login user
//    public String loginUser(String userId) {
//        Optional<User> user = userRepository.findByUserId(userId);
//        return user.map(value -> "Welcome back, " + value.getName() + "!")
//                .orElse("User not found. Please register first.");
//    }
//}
//
//


//dobara register nhi kerna per raha mgr file mn save nhi horaha..
//package com.OOP.project.Book_Nest.service;
//
//import java.util.HashMap;
//
//public class UserService {
//    private HashMap<String, String> registeredUsers; // Map for storing user data
//
//    public UserService() {
//        registeredUsers = new HashMap<>();
//    }
//
//    public String registerUser(String name, String userId) {
//        if (registeredUsers.containsKey(userId)) {
//            // If user already exists, inform them
//            return "You have already registered! Please log in.";
//        } else {
//            // Otherwise, add the user
//            registeredUsers.put(userId, name);
//            return "Registration successful! You can now log in.";
//        }
//    }
//
//    public String loginUser(String userId) {
//        if (registeredUsers.containsKey(userId)) {
//            // Welcome back if the user exists
//            return "Welcome back, " + registeredUsers.get(userId) + "!";
//        } else {
//            // User is not registered
//            return "User ID not found. Please register first.";
//        }
//    }
//}

//File mn save bhi horaha hai sab kaam...
package com.OOP.project.Book_Nest.service;

import java.io.*;
import java.util.HashMap;

public class UserService {
    private HashMap<String, String> registeredUsers; // Map for storing user data
    private static final String FILE_PATH = "C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\userData.txt";
    // File to store user data

    public UserService() {
        registeredUsers = new HashMap<>();
        loadUserData(); // Load existing users from file when the program starts
    }

    // Register user
    public String registerUser(String name, String userId) {
        if (registeredUsers.containsKey(userId)) {
            return "You have already registered! Please log in.";
        } else {
            registeredUsers.put(userId, name);
            saveUserData(); // Save updated users to file
            return "Registration successful! You can now log in.";
        }
    }

    // Login user
    public String loginUser(String userId) {
        if (registeredUsers.containsKey(userId)) {
            return "Welcome back, " + registeredUsers.get(userId) + "!";
        } else {
            return "User ID not found. Please register first.";
        }
    }

    // Save the user data to a file
    private void saveUserData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\userData.txt"))) {
            for (String userId : registeredUsers.keySet()) {
                writer.write(userId + ":" + registeredUsers.get(userId));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load the user data from a file
    private void loadUserData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\hp hp\\Downloads\\Book_Nest\\src\\main\\java\\com\\OOP\\project\\Book_Nest\\userData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    registeredUsers.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




