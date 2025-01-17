package com.ygornacif.patient_api.dto;

import com.ygornacif.patient_api.entities.Patient;
import lombok.Data;

@Data
public class DietPlanDto {

    private Long patientId;

    private Patient patient;
    private String planDetails;
}
