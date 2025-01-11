package com.ygornacif.patient_api.mapper;

import com.ygornacif.patient_api.dto.ProgressDto;
import com.ygornacif.patient_api.entities.Progress;

public class ProgressMapper {

    public static ProgressDto mapToDto(Progress progress, ProgressDto progressDto) {
        if (progress == null) {
            return null;
        }
        progressDto.setPatient(progress.getPatient());
        progressDto.setDetails(progress.getDetails());
        return progressDto;
    }

    public static Progress mapToEntity(ProgressDto progressDto, Progress progress) {
        if (progressDto == null) {
            return null;
        }
        progress.setPatient(progressDto.getPatient());
        progress.setDetails(progressDto.getDetails());
        return progress;
    }
}
