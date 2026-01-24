package com.dev.appointment_management.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private String role;
    private boolean active;
}
