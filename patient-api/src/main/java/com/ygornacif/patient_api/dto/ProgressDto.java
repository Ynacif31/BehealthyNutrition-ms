package com.ygornacif.patient_api.dto;

import com.ygornacif.patient_api.entities.Patient;
import lombok.Data;

@Data
public class ProgressDto {

    private Patient patient;
    private String details;

}
