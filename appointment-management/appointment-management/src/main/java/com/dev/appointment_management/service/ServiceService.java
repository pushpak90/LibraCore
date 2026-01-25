package com.dev.appointment_management.service;

import com.dev.appointment_management.dto.request.CreateServiceRequest;
import com.dev.appointment_management.dto.response.ServiceResponse;

import java.util.List;

public interface ServiceService {
    ServiceResponse createService(CreateServiceRequest request);
    List<ServiceResponse> getActiveServices();
}
