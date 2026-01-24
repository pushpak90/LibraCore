package com.dev.appointment_management.mapper;

import com.dev.appointment_management.dto.response.AppointmentResponse;
import com.dev.appointment_management.entity.Appointment;

public class AppointmentMapper {
    private AppointmentMapper(){}

    public static AppointmentResponse toResponse(Appointment appointment){
        AppointmentResponse response = new AppointmentResponse();

        response.setId(appointment.getId());
        response.setUserId(appointment.getUser().getId());
        response.setServiceName(appointment.getService().getName());
        response.setAppointment(appointment.getAppointmentTime());
        response.setStatus(appointment.getStatus().name());

        return response;
    }

}
