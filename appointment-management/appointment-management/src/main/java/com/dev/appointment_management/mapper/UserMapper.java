package com.dev.appointment_management.mapper;

import com.dev.appointment_management.dto.request.CreateRequest;
import com.dev.appointment_management.dto.response.UserResponse;
import com.dev.appointment_management.entity.Role;
import com.dev.appointment_management.entity.User;

public class UserMapper {

    private UserMapper(){}

    public static User toEntity(CreateRequest request, Role role){
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(role);
        return user;
    }

    public static UserResponse toResponse(User user){
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().getName());
        response.setActive(user.isActive());

        return response;
    }

}
