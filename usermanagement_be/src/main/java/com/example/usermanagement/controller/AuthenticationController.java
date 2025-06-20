package com.example.usermanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermanagement.dto.request.AuthenticationRequest;
import com.example.usermanagement.dto.response.ApiResponse;
import com.example.usermanagement.dto.response.AuthenticationResponse;
import com.example.usermanagement.service.AuthenticationService;

// import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
// @RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder().result(result).build();
    }
}
