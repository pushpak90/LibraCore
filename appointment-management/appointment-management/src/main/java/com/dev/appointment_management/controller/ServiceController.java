package com.dev.appointment_management.controller;

import com.dev.appointment_management.dto.request.CreateServiceRequest;
import com.dev.appointment_management.dto.response.ServiceResponse;
import com.dev.appointment_management.service.ServiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ServiceResponse> createService(@Valid @RequestBody CreateServiceRequest request){
        ServiceResponse response = serviceService.createService(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServiceResponse>> getActiveSerices(){
        List<ServiceResponse> response = serviceService.getActiveServices();
        return ResponseEntity.ok(response);
    }
}
