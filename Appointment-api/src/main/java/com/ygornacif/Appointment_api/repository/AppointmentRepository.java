package com.ygornacif.Appointment_api.repository;

import com.ygornacif.Appointment_api.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findById(Long id);
    Optional<Appointment> findByPatientId(String patientId);
    Optional<Appointment> findByNutritionistId(String nutritionistId);
}
