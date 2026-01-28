package com.dev.appointment_management.service.Impl;

import com.dev.appointment_management.dto.request.CreateRequest;
import com.dev.appointment_management.dto.response.UserResponse;
import com.dev.appointment_management.entity.Role;
import com.dev.appointment_management.entity.User;
import com.dev.appointment_management.exception.BusinessException;
import com.dev.appointment_management.exception.ResourceNotFoundException;
import com.dev.appointment_management.mapper.UserMapper;
import com.dev.appointment_management.repository.RoleRepository;
import com.dev.appointment_management.repository.UserRepository;
import com.dev.appointment_management.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository)
    {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse createUser(CreateRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
            throw new BusinessException("Email already exists");
        }

        Role role = roleRepository.findByName(request.getRole())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        User user = UserMapper.toEntity(request, role);
        User saved = userRepository.save(user);

        return UserMapper.toResponse(saved);
    }
}
