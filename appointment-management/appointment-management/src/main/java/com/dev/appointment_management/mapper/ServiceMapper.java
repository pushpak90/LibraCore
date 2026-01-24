package com.dev.appointment_management.mapper;

import com.dev.appointment_management.dto.request.CreateServiceRequest;
import com.dev.appointment_management.dto.response.ServiceResponse;
import com.dev.appointment_management.entity.Service;

public class ServiceMapper {
    private ServiceMapper(){}

    public static Service toEntity(CreateServiceRequest request){
        Service service = new Service();

        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setDurationInMinutes(request.getDurationInMinutes());

        return  service;
    }

    public static ServiceResponse toResponse(Service service){
        ServiceResponse response = new ServiceResponse();

        response.setId(service.getId());
        response.setName(service.getName());
        response.setDescription(service.getDescription());
        response.setDurationInMinutes(service.getDurationInMinutes());
        response.setActive(service.isActive());

        return response;
    }
}
