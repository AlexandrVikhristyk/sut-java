package com.example.javaproject.service;

import com.example.javaproject.entity.User;
import com.example.javaproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCRUDService {
    @Autowired
    private UserRepository userRepository;

    //These methods are enough for 60 score; <- !!!!!!!!!!!!!!!!!!!!!
    private void testUserRepository() {
        User user = new User();

        //CRUD
        //C & U - Create & Update
        //INSERT INTO USER VALUES(user.id, user.name ...);
        userRepository.save(user); // We can use it for updating entities; INSERT and UPDATE!

        //R - Read
        //SELECT * FROM USER;
        userRepository.findAll();

        //SELECT * FROM USER WHERE USER.ID=id;
        userRepository.findById(3L);

        //SELECT * FROM USER WHERE USER.ID=id;
        userRepository.getById(1L);

        //D - Delete
        //DELETE FROM USER WHERE 1=1;
        userRepository.deleteAll();

        //DELETE FROM USER WHERE USER=user;
        userRepository.delete(user);

        //DELETE FROM USER WHERE USER.id=id;
        userRepository.deleteById(2L);

        //H - Helpers
        //SELECT COUNT(id) > 0 FROM USER:
        userRepository.existsById(1L);

        //COMMIT;
        userRepository.flush();

        //SELECT COUNT(*) FROM USER;
        userRepository.count();

        //BEGIN; .... INSERT INTO USER VALUES (....)COMMIT; (flush) .....; COMMIT
        userRepository.saveAndFlush(user);

        String username = "Gena";
        //CUSTOM METHODS
        //SELECT COUNT(username) > 0 FROM USER GROUP BY USER.username:
        userRepository.existsByUsername(username);

//        User gena = userRepository.findByUsername("Gena").get();
//        gena.getUsername(); // If userRepository.findByUsername("Gena") returns null we will receive NPE (Null Pointer Exception)


        Optional<User> gena = userRepository.findByUsername(username);

        gena.orElse(new User()); // If gena == null than replace by new User()
        gena.orElseThrow(() -> new RuntimeException("User not found by username " + username)); // If gena == null than throw an error
        gena.ifPresent(userFromDb -> userFromDb.setAge(5)); // If gena != null, run code in brackets
        gena.isPresent(); // Instead of gena == null clause

    }
}
