package com.example.usermanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.usermanagement.dto.request.RoleRequest;
import com.example.usermanagement.dto.response.RoleResponse;
import com.example.usermanagement.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    @Mapping(target = "id", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
