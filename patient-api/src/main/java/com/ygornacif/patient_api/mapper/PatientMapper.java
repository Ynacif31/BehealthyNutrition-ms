package com.ygornacif.patient_api.mapper;

import com.ygornacif.patient_api.dto.PatientDto;
import com.ygornacif.patient_api.entities.ConsultationHistory;
import com.ygornacif.patient_api.entities.Patient;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
        patientDto.setConsultationHistory(
                patient.getConsultationHistory().stream()
                        .map(ConsultationHistoryMapper::mapToConsultationHistoryDto)
                        .collect(Collectors.toList())
        );
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

        if (patientDto.getConsultationHistory() != null) {
            patient.setConsultationHistory(
                    patientDto.getConsultationHistory().stream()
                            .map(dto -> ConsultationHistoryMapper.mapToConsultationHistory(dto, new ConsultationHistory()))
                            .collect(Collectors.toList())
            );
        } else {
            patient.setConsultationHistory(new ArrayList<>());
        }

        patient.setImc(calculateImc(patientDto.getWeight(), patientDto.getHeight()));
        return patient;
    }

    private static Double calculateImc(Double weight, Double height) {
        if (weight == null || height == null || height == 0) {
            return null;
        }
        return weight / (height * height);
    }
}

