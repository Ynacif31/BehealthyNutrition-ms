package com.ygornacif.patient_api.mapper;

import com.ygornacif.patient_api.dto.ConsultationHistoryDto;
import com.ygornacif.patient_api.entities.ConsultationHistory;
import com.ygornacif.patient_api.entities.Patient;

import java.time.LocalDate;
import java.time.ZoneId;


public class ConsultationHistoryMapper {

    public static ConsultationHistoryDto mapToConsultationHistoryDto(ConsultationHistory consultationHistory) {
        if (consultationHistory == null) {
            return null;
        }
        ConsultationHistoryDto consultationHistoryDto = new ConsultationHistoryDto();// Mapeando o campo id
        consultationHistoryDto.setId(consultationHistory.getId()); // Mapeando o campo id
        consultationHistoryDto.setPatientId(consultationHistory.getPatient().getPatientId());
        consultationHistoryDto.setNotes(consultationHistory.getNotes());
        consultationHistoryDto.setConsultationDate(consultationHistory.getConsultationDate());
        consultationHistoryDto.setNextConsultationDate(consultationHistory.getNextConsultationDate().atStartOfDay());

        return consultationHistoryDto;
    }
    public static ConsultationHistory mapToConsultationHistory(ConsultationHistoryDto consultationHistoryDto, ConsultationHistory consultationHistory) {
        if (consultationHistoryDto == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setPatientId(consultationHistoryDto.getPatientId());
        consultationHistory.setId(consultationHistoryDto.getId());
        consultationHistory.setPatient(patient);
        consultationHistory.setNotes(consultationHistoryDto.getNotes());
        consultationHistory.setConsultationDate(consultationHistoryDto.getConsultationDate());

        if (consultationHistoryDto.getConsultationDate() != null) {
            LocalDate consultationDate = consultationHistoryDto.getConsultationDate();
            consultationHistory.setNextConsultationDate(consultationDate.plusDays(90));
        }

        return consultationHistory;
    }
}
