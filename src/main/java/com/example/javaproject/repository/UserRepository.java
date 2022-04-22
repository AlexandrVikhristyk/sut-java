package com.example.javaproject.repository;

import com.example.javaproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { //User - entity, Long - type of id in User entity
    boolean existsByUsername(String username);
    Optional<User> findByUsername(@Param("username") String name);

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.username = :username") //JPQL query (Java Persistence Query Language).
        // Allows us to write query depending on objects and field instead of tables and columns;
    boolean findShortName(Long id, @Param("username") String gg);
}
