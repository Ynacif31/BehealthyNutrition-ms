package com.ygornacif.patient_api.service;

import com.ygornacif.patient_api.dto.ConsultationHistoryDto;
import com.ygornacif.patient_api.dto.PatientDto;

import java.util.List;

public interface IConsultationHistoryService {

    List<ConsultationHistoryDto> fetchConsultationHistoryByPatientId(Long patientId);

    void createConsultationHistory(ConsultationHistoryDto consultationHistoryDto);

    /**
     * @param consultationHistoryDto - ConsultationHistory Object
     * @return boolean indicating if the update of patient details is successful or not
     */
    boolean updateConsultationHistory(ConsultationHistoryDto consultationHistoryDto);

    boolean deleteConsultationHistory(Long consultationHistoryId);
}
