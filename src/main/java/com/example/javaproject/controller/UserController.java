package com.example.javaproject.controller;

import com.example.javaproject.entity.User;
import com.example.javaproject.payload.dto.UserDto;
import com.example.javaproject.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // <- It is for specifying that it is REST approach, also we have @Controller (But in this way we should specify every method as @ResponseBody)
@RequestMapping("/api/user") //Make this controller responsible for specified url path (In local env it will be localhost:8080/api/user for this case)
public class UserController {

//    @Autowired <- Old way to use IoC in Spring Boot
//    @Qualifier(name_of_bean) <- Choose the implementation
    private final UserService userService;
//    private UserService userServiceDI; <- Dependency Inversion approach

    public UserController(UserService userService) {
        this.userService = userService; //IoC (Inversion of control) approach
//        this.userServiceDI = new UserServiceImpl(); Dependency Inversion approach
    }

    @GetMapping("/{id}") //GET/POST/PUT...Mapping for specifying responsible endpoint (Fot this case url should look like localhost:8080/api/user/5 {Where 5 is userId})
//    @RequestMapping(value = "/{userId}", method = RequestMethod.GET) <-- Old version, use the previous one
    public User getUser(@PathVariable Long id) { // @RequestParam (url?id=someValue) || @PathVariable (url/someValue) || @RequestBody (We should pass it in the http body)
        return userService.getUserById(id);
    }

    @PostMapping //We are able to not specify any endpoint in the annotation param. (In this case we will find the method by Http METHOD and ulr will be localhost:8080/api/user)
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("User deleted successfully");
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userId, userDto));
    }

}
