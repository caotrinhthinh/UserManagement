package com.example.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usermanagement.entity.InvalidatedToken;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {

}
