package com.ygornacif.patient_api.mapper;

import com.ygornacif.patient_api.dto.PatientDto;
import com.ygornacif.patient_api.entities.Patient;

public class PatientMapper {

    public static PatientDto mapToPatientDto(Patient patient, PatientDto patientDto) {
        if (patient == null) {
            return null;
        }
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setMobileNumber(patient.getMobileNumber());
        patientDto.setGender(patient.getGender());
        patientDto.setBirthDate(patient.getBirthDate());
        patientDto.setHeight(patient.getHeight());
        patientDto.setWeight(patient.getWeight());
        patientDto.setImc(patient.getImc());
        return patientDto;
    }

    public static Patient mapToPatient(PatientDto patientDto, Patient patient) {
        if (patientDto == null) {
            return null;
        }

        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setGender(patientDto.getGender());
        patient.setBirthDate(patientDto.getBirthDate());
        patient.setHeight(patientDto.getHeight());
        patient.setWeight(patientDto.getWeight());
        // Calcule o IMC automaticamente ao mapear para o paciente
        patient.setImc(calculateImc(patientDto.getWeight(), patientDto.getHeight()));
        return patient;
    }

    private static Double calculateImc(Double weight, Double height) {
        if (weight == null || height == null || height == 0) {
            return 0.0;
        }
        return weight / (height * height);
    }
}
