package com.example.javaproject.service.interfaces;

import com.example.javaproject.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User updateUser(Long userId, User user);
    void deleteUser(Long id);
}
