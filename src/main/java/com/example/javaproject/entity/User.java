package com.example.javaproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserTable") //not required
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;
    @Column(name = "firstname", updatable = false) //not required
    private String name;
    private String lastname;
    private String email;
    private Integer age; //Integer (Object, Wrapper) - not int (primitive)

    public User() {
    }

    public User(Long id, String username, String name, String lastname, String email, Integer age) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
