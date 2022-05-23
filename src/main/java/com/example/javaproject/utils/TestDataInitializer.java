package com.example.javaproject.utils;

import com.example.javaproject.entity.Permission;
import com.example.javaproject.entity.Role;
import com.example.javaproject.entity.User;
import com.example.javaproject.entity.enumeration.RolePermission;
import com.example.javaproject.entity.enumeration.UserRole;
import com.example.javaproject.repository.PermissionRepository;
import com.example.javaproject.repository.RoleRepository;
import com.example.javaproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TestDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setName(UserRole.USER.getRole());
        roleRepository.save(role);

        Role role2 = new Role();
        role2.setName(UserRole.ADMIN.getRole());
        roleRepository.save(role2);

        User user = new User();
        user.setLastname("User");
        user.setUsername("user");
        user.setName("Name");
        user.setAge(18);
        user.setEmail("user@gmail.com");
        user.setPassword(passwordEncoder.encode("test123"));
        user.setRole(role);
        userRepository.save(user);


        User user2 = new User();
        user2.setLastname("User");
        user2.setUsername("admin");
        user2.setName("Name");
        user2.setAge(18);
        user2.setEmail("admin@gmail.com");
        user2.setPassword(passwordEncoder.encode("test123"));
        user2.setRole(role2);
        userRepository.save(user2);


        Permission permission = new Permission();
        permission.setName(RolePermission.REGISTER.name());
        permission.setRole(role2);
        permissionRepository.save(permission);

    }
}
