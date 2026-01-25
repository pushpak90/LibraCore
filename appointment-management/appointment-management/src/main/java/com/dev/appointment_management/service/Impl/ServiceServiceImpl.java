package com.dev.appointment_management.service.Impl;

import com.dev.appointment_management.dto.request.CreateServiceRequest;
import com.dev.appointment_management.dto.response.ServiceResponse;
import com.dev.appointment_management.mapper.ServiceMapper;
import com.dev.appointment_management.repository.ServiceRepository;
import com.dev.appointment_management.service.ServiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }

    @Override
    public ServiceResponse createService(CreateServiceRequest request) {
        com.dev.appointment_management.entity.Service service = ServiceMapper.toEntity(request);
        com.dev.appointment_management.entity.Service savedService = serviceRepository.save(service);
        return ServiceMapper.toResponse(savedService);
    }

    @Override
    public List<ServiceResponse> getActiveServices() {
        return serviceRepository.findByActiveTrue()
                .stream()
                .map(ServiceMapper::toResponse)
                .collect(Collectors.toList());
    }
}
