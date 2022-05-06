package com.example.javaproject.mapper;

import com.example.javaproject.entity.User;
import com.example.javaproject.payload.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

//    @Mapping(target = "name", source = "userDto.firstName")
//    @Mapping(target = "lastName", source = "anyDto.name")
    @Mapping(target = "id", ignore = true)
    User fromDto(UserDto userDto); //, UserService anyDto);

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    void updateUser(@MappingTarget User user, UserDto userDto);
}
