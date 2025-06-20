package com.example.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermanagement.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
