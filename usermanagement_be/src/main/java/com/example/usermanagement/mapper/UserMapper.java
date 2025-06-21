package com.example.usermanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.usermanagement.dto.request.UserCreationRequest;
import com.example.usermanagement.dto.request.UserUpdateRequest;
import com.example.usermanagement.dto.response.UserResponse;
import com.example.usermanagement.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User touser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
