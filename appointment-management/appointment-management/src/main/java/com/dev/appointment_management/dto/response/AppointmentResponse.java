package com.dev.appointment_management.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentResponse {
    private Long id;
    private Long userId;
    private String serviceName;
    private LocalDateTime appointment;
    private String status;
}
