package com.example.javaproject.service;

import com.example.javaproject.entity.User;
import com.example.javaproject.repository.UserRepository;
import com.example.javaproject.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service // Or @Controller or @Component or @Configuration or @Repository or @RestController or @Bean (It works only ahead method);
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //C - create
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //R - read
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found by id - " + id));
    }

    //U - update
    public User updateUser(Long userId, User user) {
        User userFromDb = getUserById(userId);

        //Here should be mapper (Also, we don't want to re-write ID)
        userFromDb.setName(user.getName());
        userFromDb.setUsername(user.getUsername());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setAge(user.getAge());
        userFromDb.setLastname(user.getLastname());

        return userRepository.save(userFromDb);
    }

    //D - delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
