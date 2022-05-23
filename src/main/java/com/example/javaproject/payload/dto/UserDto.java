package com.example.javaproject.payload.dto;

//Should contain only validation || lombok annotations
//Recommended to not contain any object fields
//We are able to combine fields from a couple entities
//Not a rule to copy all the fields from entity (We should transfer only what we need)

import lombok.Data;

@Data
public class UserDto { //DTO - Data Transfer Object
    private Long id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private Integer age;
    private String password;
}
