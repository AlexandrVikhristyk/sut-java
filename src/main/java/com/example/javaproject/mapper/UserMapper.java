package com.example.javaproject.mapper;

import com.example.javaproject.entity.User;
import com.example.javaproject.payload.dto.UserDto;
import com.example.javaproject.payload.request.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

//    @Mapping(target = "name", source = "userDto.firstName")
//    @Mapping(target = "lastName", source = "anyDto.name")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User fromDto(UserDto userDto); //, UserService anyDto);

    @Mapping(target = "role", expression = "java(user.getRole().getName())")
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    void updateUser(@MappingTarget User user, UserDto userDto);

    User fromDto(RegisterRequest registerRequest);
}
