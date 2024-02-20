package com.example.equipment.security;

public enum UserRole {
    USER("User"),
    MANAGER("Manager");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
