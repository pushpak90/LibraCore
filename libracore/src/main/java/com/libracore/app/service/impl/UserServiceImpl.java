package com.libracore.app.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.libracore.app.dto.auth.RegisterRequest;
import com.libracore.app.entity.Role;
import com.libracore.app.entity.User;
import com.libracore.app.repository.UserRepository;
import com.libracore.app.security.JwtUtil;
import com.libracore.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public void register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Email already registered");
        }

        User user = User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .role(Role.MEMBER)
                    .build();
                    
        userRepository.save(user);

    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Invalid email or password"));
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new IllegalArgumentException("Invalid email or password");
        }
        return jwtUtil.generateToken(user.getEmail(), user.getPassword());
    }
    
}
