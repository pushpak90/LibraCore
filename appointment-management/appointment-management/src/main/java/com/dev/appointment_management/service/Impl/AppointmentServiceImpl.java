package com.dev.appointment_management.service.Impl;

import com.dev.appointment_management.dto.request.CreateAppointmentRequest;
import com.dev.appointment_management.dto.response.AppointmentResponse;
import com.dev.appointment_management.entity.Appointment;
import com.dev.appointment_management.entity.User;
import com.dev.appointment_management.mapper.AppointmentMapper;
import com.dev.appointment_management.repository.AppointmentRepository;
import com.dev.appointment_management.repository.ServiceRepository;
import com.dev.appointment_management.repository.UserRepository;
import com.dev.appointment_management.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;

    public AppointmentServiceImpl(
            AppointmentRepository appointmentRepository,
            UserRepository userRepository,
            ServiceRepository serviceRepository
                                  ){
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public AppointmentResponse bookAppointment(CreateAppointmentRequest request) {

        User user = userRepository.findById(request.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found"));

        com.dev.appointment_management.entity.Service service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        boolean alreadyBooked = appointmentRepository
                .existsByServiceIdAndAppointmentTime(
                        service.getId(),
                        request.getAppointmentTime()
                );

        if(alreadyBooked){
            throw new RuntimeException("Time slot already booked for this service");
        }

        Appointment appointment = new Appointment();

        appointment.setUser(user);
        appointment.setService(service);
        appointment.setAppointmentTime(request.getAppointmentTime());

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return AppointmentMapper.toResponse(savedAppointment);
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return appointmentRepository.findByUser(user)
                .stream()
                .map(AppointmentMapper :: toResponse)
                .collect(Collectors.toList());
    }
}
