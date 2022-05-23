package com.example.javaproject.service;

import com.example.javaproject.entity.User;
import com.example.javaproject.mapper.UserMapper;
import com.example.javaproject.payload.request.LoginRequest;
import com.example.javaproject.payload.request.RegisterRequest;
import com.example.javaproject.repository.UserRepository;
import com.example.javaproject.service.interfaces.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void login(LoginRequest loginRequest) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
    }

    @Override
    public User register(RegisterRequest registerRequest) {
        User user = userMapper.fromDto(registerRequest);
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }
}
