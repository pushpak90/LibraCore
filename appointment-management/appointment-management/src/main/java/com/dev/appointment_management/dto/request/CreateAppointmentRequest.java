package com.dev.appointment_management.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateAppointmentRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long serviceId;
    @NotNull
    @Future
    private LocalDateTime appointmentTime;
}
