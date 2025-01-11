package com.ygornacif.patient_api.repositories;

import com.ygornacif.patient_api.entities.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
    List<DietPlan> findByPatientId(Long patientId);
}