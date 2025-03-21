package com.ygornacif.patient_api.service.impl;

import com.ygornacif.patient_api.dto.ConsultationHistoryDto;
import com.ygornacif.patient_api.entities.ConsultationHistory;
import com.ygornacif.patient_api.exceptions.ConsultationHistoryNotFoundException;
import com.ygornacif.patient_api.exceptions.ResourceNotFoundException;
import com.ygornacif.patient_api.mapper.ConsultationHistoryMapper;
import com.ygornacif.patient_api.repositories.ConsultationHistoryRepository;
import com.ygornacif.patient_api.service.IConsultationHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ConsultationHistoryServiceImpl implements IConsultationHistoryService {

    private final ConsultationHistoryRepository consultationHistoryRepository;


    @Override
    public List<ConsultationHistoryDto> fetchConsultationHistoryByPatientId(Long patientId) {
        List<ConsultationHistory> consultationHistoryList = consultationHistoryRepository.findByPatient_PatientId(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Consultation History", "patientId", String.valueOf(patientId)));

        // Mapeando cada ConsultationHistory para ConsultationHistoryDto
        return consultationHistoryList.stream()
                .map(ConsultationHistoryMapper::mapToConsultationHistoryDto)
                .collect(Collectors.toList());
    }
    @Override
    public void createConsultationHistory(ConsultationHistoryDto consultationHistoryDto) {
        ConsultationHistory consultationHistory = ConsultationHistoryMapper.mapToConsultationHistory(consultationHistoryDto, new ConsultationHistory());
        consultationHistoryRepository.save(consultationHistory);
    }

    @Override
    public boolean updateConsultationHistory(ConsultationHistoryDto consultationHistoryDto) {
        try {
            consultationHistoryRepository.findById(consultationHistoryDto.getId());
            ConsultationHistory updatedConsultationHistory = ConsultationHistoryMapper.mapToConsultationHistory(consultationHistoryDto, new ConsultationHistory());
            consultationHistoryRepository.save(updatedConsultationHistory);
            return true;
        } catch (ConsultationHistoryNotFoundException e) {
            throw new ConsultationHistoryNotFoundException("Consultation History with id " + consultationHistoryDto.getId() + " not found");
        }
    }

    @Override
    public boolean deleteConsultationHistory(Long consultationHistoryId) {
        ConsultationHistory consultationHistory = consultationHistoryRepository.
                findById(consultationHistoryId)
                .orElseThrow(
                        () -> new ConsultationHistoryNotFoundException("History with id" + consultationHistoryId + "not found"));

        consultationHistoryRepository.delete(consultationHistory);
        return true;
    }
}