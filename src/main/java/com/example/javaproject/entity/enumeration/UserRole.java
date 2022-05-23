package com.example.javaproject.entity.enumeration;

public enum UserRole {
    USER,
    ADMIN;

    public String getRole() {
        return "ROLE_" + name();
    }
}
