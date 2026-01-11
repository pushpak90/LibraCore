package com.libracore.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libracore.app.dto.auth.RegisterRequest;
import com.libracore.app.dto.auth.RegisterResponse;
import com.libracore.app.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> Registration(@Valid @RequestBody RegisterRequest request) {
        userService.register(request);
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new RegisterResponse("User Registered successfully!"));
    }
    
}
