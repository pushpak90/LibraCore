package com.dev.appointment_management.service;

import com.dev.appointment_management.dto.request.LoginRequest;
import com.dev.appointment_management.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}
