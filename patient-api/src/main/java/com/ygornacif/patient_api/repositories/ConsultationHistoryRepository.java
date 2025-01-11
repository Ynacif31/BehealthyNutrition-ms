package com.ygornacif.patient_api.repositories;

import com.ygornacif.patient_api.entities.ConsultationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultationHistoryRepository extends JpaRepository<ConsultationHistory, Long> {
    Optional<ConsultationHistory> findById(Long id);
    Optional<List<ConsultationHistory>> findByPatient_PatientId(Long patientId);
}
