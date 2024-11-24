//UserController
package com.OOP.project.Book_Nest.controller;

import com.OOP.project.Book_Nest.service.UserService;
import java.util.Scanner;

public class UserController {

    private UserService userService;

    // Constructor to initialize the userService
    public UserController() {
        this.userService = new UserService(); // Initialize user service
    }

    // Run method to manage user interaction
    public void run() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        while (true) {
            System.out.println("Welcome to Book Nest! Please choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                // Register user
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                System.out.println("Enter your user ID:");
                String userId = scanner.nextLine();
                System.out.println(userService.registerUser(name, userId));
            } else if ("2".equals(choice)) {
                // Login user
                System.out.println("Enter your user ID to login:");
                String userId = scanner.nextLine();
                System.out.println(userService.loginUser(userId));
            } else if ("3".equals(choice)) {
                // Exit
                System.out.println("Thank you for using Book Nest!");
                break;
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close(); // Close scanner

    }
}
