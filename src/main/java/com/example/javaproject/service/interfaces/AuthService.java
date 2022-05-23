package com.example.javaproject.service.interfaces;

import com.example.javaproject.entity.User;
import com.example.javaproject.payload.request.LoginRequest;
import com.example.javaproject.payload.request.RegisterRequest;

public interface AuthService {
    void login(LoginRequest loginRequest);
    User register(RegisterRequest registerRequest);
}
