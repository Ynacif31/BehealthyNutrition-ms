package com.ygornacif.patient_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ygornacif.patient_api.entities.ConsultationHistory;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(name = "ConsultationHistory",
        description = "Schema to hold ConsultationHistory information"
)
@Data
public class ConsultationHistoryDto {

    @Schema(
            description = "ConsultationHistory id", example = "1"
    )
    private Long id;
    @Schema(
            description = "ConsultationHistory patientId", example = "1"
    )
    private Long patientId;
    @Schema(
            description = "ConsultationHistory notes", example = "Patient is feeling better"
    )
    private String notes;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull(message = "Consultation date is required")
    @Schema(description = "ConsultationHistory consultation date", example = "2025-01-13T10:00:00")
    private LocalDateTime consultationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(description = "ConsultationHistory next consultation date", example = "2025-01-13T10:00:00")
    private LocalDateTime nextConsultationDate;
}