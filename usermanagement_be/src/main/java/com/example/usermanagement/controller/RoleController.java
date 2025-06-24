package com.example.usermanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.usermanagement.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
}
