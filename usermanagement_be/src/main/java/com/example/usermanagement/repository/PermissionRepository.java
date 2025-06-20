package com.example.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermanagement.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
