package com.ygornacif.patient_api.mapper;

import com.ygornacif.patient_api.dto.ConsultationHistoryDto;
import com.ygornacif.patient_api.entities.ConsultationHistory;
import com.ygornacif.patient_api.entities.Patient;


public class ConsultationHistoryMapper {

    public static ConsultationHistoryDto mapToConsultationHistoryDto(ConsultationHistory consultationHistory) {
        if (consultationHistory == null) {
            return null;
        }
        ConsultationHistoryDto consultationHistoryDto = new ConsultationHistoryDto();
        consultationHistoryDto.setId(consultationHistory.getId()); // Mapeando o campo id
        consultationHistoryDto.setPatientId(consultationHistory.getPatient().getPatientId());
        consultationHistoryDto.setNotes(consultationHistory.getNotes());

        return consultationHistoryDto;
    }
    public static ConsultationHistory mapToConsultationHistory(ConsultationHistoryDto consultationHistoryDto, ConsultationHistory consultationHistory) {
        if (consultationHistoryDto == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setPatientId(consultationHistoryDto.getPatientId());
        consultationHistory.setPatient(patient);
        consultationHistory.setNotes(consultationHistoryDto.getNotes());
        return consultationHistory;
    }
}
