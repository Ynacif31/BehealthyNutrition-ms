package com.ygornacif.patient_api.service;

import com.ygornacif.patient_api.dto.ConsultationHistoryDto;

import java.util.List;

public interface IConsultationHistoryService {

    List<ConsultationHistoryDto> fetchConsultationHistoryByPatientId(Long patientId);

    void createConsultationHistory(ConsultationHistoryDto consultationHistoryDto);
}
