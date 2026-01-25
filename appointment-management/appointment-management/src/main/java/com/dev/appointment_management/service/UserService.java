package com.dev.appointment_management.service;

import com.dev.appointment_management.dto.request.CreateRequest;
import com.dev.appointment_management.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(CreateRequest request);
}
