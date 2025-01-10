package com.ygornacif.patient_api.repositories;

import com.ygornacif.patient_api.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Override
    Optional<Patient> findById(Long patientId);
}
