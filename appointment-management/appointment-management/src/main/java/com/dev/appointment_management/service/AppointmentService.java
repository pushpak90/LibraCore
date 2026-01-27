package com.dev.appointment_management.service;

import com.dev.appointment_management.dto.request.CreateAppointmentRequest;
import com.dev.appointment_management.dto.response.AppointmentResponse;

import java.util.List;

public interface AppointmentService {
    AppointmentResponse bookAppointment(CreateAppointmentRequest request);
    List<AppointmentResponse> getAppointmentsByUser(Long userId);
}
