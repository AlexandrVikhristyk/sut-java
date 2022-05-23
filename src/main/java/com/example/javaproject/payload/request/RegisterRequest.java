package com.example.javaproject.payload.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String name;
    private String lastname;
    private String email;
    private Integer age;
    private String password;
}
