package com.ygornacif.patient_api.repositories;

import com.ygornacif.patient_api.entities.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByPatientId(Long patientId);
}