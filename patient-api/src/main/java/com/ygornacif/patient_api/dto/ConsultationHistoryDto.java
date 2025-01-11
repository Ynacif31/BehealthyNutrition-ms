package com.ygornacif.patient_api.dto;

import com.ygornacif.patient_api.entities.Patient;
import lombok.Data;

@Data
public class ConsultationHistoryDto {

    private Long id;
    private Long patientId;
    private String notes;
}