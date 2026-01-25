package com.dev.appointment_management.repository;

import com.dev.appointment_management.entity.Appointment;
import com.dev.appointment_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUser(User user);
    boolean existsByServiceIdAndAppointmentTime(Long serviceId, LocalDateTime appointmentTime);
}
