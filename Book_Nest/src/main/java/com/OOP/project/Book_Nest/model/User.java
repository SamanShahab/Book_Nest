//User.java
package com.OOP.project.Book_Nest.model;

public class User {
    private String id; // String type for ID
    private String name;
    private String userId;

    // Default constructor
    public User() {}

    // Constructor without ID (for new users)
    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    // Constructor with ID (for all cases)
    public User(String id, String name, String userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
