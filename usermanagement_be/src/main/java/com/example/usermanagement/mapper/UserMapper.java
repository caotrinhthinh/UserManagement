package com.example.usermanagement.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.usermanagement.dto.request.UserCreationRequest;
import com.example.usermanagement.dto.request.UserUpdateRequest;
import com.example.usermanagement.dto.response.UserResponse;
import com.example.usermanagement.entity.Role;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.RoleRepository;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    protected RoleRepository roleRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true) // ánh xạ thủ công ở @AfterMapping
    public abstract User touser(UserCreationRequest request);

    public abstract UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract void updateUser(@MappingTarget User user, UserUpdateRequest request);

    @AfterMapping
    protected void mapRoles(UserCreationRequest request, @MappingTarget User user) {
        if (request.getRoles() != null && !request.getRoles().isEmpty()) {
            Set<Role> roles = new HashSet<>(roleRepository.findAllById(request.getRoles()));
            user.setRoles(roles);
        }
    }
}
