package com.dev.appointment_management.service.Impl;

import com.dev.appointment_management.dto.request.LoginRequest;
import com.dev.appointment_management.dto.response.LoginResponse;
import com.dev.appointment_management.entity.User;
import com.dev.appointment_management.exception.BusinessException;
import com.dev.appointment_management.exception.ResourceNotFoundException;
import com.dev.appointment_management.repository.UserRepository;
import com.dev.appointment_management.sercurity.JwtUtil;
import com.dev.appointment_management.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new BusinessException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(loginRequest.getEmail(), loginRequest.getPassword());

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);

        return loginResponse;
    }
}
