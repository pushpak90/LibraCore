package com.dev.appointment_management.controller;

import com.dev.appointment_management.dto.request.CreateAppointmentRequest;
import com.dev.appointment_management.dto.response.AppointmentResponse;
import com.dev.appointment_management.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping
    public ResponseEntity<AppointmentResponse> bookAppointment(@Valid @RequestBody CreateAppointmentRequest request){
        AppointmentResponse appointmentResponse = appointmentService.bookAppointment(request);
        return new ResponseEntity<>(appointmentResponse, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('CUSTOMER','ADMIN')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByUser(
            @PathVariable Long userId) {

        List<AppointmentResponse> appointments =
                appointmentService.getAppointmentsByUser(userId);

        return ResponseEntity.ok(appointments);
    }
}
