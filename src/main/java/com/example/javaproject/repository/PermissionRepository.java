package com.example.javaproject.repository;

import com.example.javaproject.entity.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Long> {
}
