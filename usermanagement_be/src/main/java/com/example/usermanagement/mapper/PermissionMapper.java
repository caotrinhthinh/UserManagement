package com.example.usermanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.usermanagement.dto.request.PermissionRequest;
import com.example.usermanagement.dto.response.PermissionResponse;
import com.example.usermanagement.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    @Mapping(target = "id", ignore = true)
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
