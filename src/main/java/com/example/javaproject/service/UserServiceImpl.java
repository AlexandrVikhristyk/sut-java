package com.example.javaproject.service;

import com.example.javaproject.entity.User;
import com.example.javaproject.mapper.UserMapper;
import com.example.javaproject.payload.dto.UserDto;
import com.example.javaproject.repository.UserRepository;
import com.example.javaproject.service.interfaces.UserService;
import org.springframework.stereotype.Service;

//@Primary <- Autowire this implementation any time (Except @Qualifier)
@Service // Or @Controller or @Component or @Configuration or @Repository or @RestController or @Bean (It works only ahead method);
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //C - create
    public User createUser(UserDto userDto) {

        User user = userMapper.fromDto(userDto);

        return userRepository.save(user);
    }

    //R - read
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found by id - " + id));
    }

    //U - update
    public User updateUser(Long userId, UserDto userDto) {
        User userFromDb = getUserById(userId);

        //Here should be mapper (Also, we don't want to re-write ID)
        userMapper.updateUser(userFromDb, userDto);

        return userRepository.save(userFromDb);
    }

    //D - delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
