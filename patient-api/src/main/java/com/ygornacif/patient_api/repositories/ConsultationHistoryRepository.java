package com.ygornacif.patient_api.repositories;

import com.ygornacif.patient_api.entities.ConsultationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationHistoryRepository extends JpaRepository<ConsultationHistory, Long> {
    List<ConsultationHistory> findByPatient(Long patientId);
}
