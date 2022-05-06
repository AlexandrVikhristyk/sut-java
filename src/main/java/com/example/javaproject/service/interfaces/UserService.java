package com.example.javaproject.service.interfaces;

import com.example.javaproject.entity.User;
import com.example.javaproject.payload.dto.UserDto;

public interface UserService {
    User createUser(UserDto user);
    User getUserById(Long id);
    User updateUser(Long userId, User user);
    void deleteUser(Long id);
}
