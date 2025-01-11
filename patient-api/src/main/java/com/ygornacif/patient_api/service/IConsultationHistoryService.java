package com.ygornacif.patient_api.service;

import com.ygornacif.patient_api.dto.ConsultationHistoryDto;

import java.util.List;

public interface IConsultationHistoryService {

    List<ConsultationHistoryDto> getConsultationHistoryByPatientId(Long patientId);

    void addConsultationHistory(ConsultationHistoryDto consultationHistoryDto);
}
