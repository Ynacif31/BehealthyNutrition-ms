package com.ygornacif.patient_api.dto;

import com.ygornacif.patient_api.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Schema(name = "Patient",
        description = "Schema to hold Patient information"
)
@Data
public class PatientDto {

    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    @Schema(
            description = "patient name", example = "Ygor Nacif"
    )
    private String name;

    @NotEmpty(message = "Email address cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    @Schema(
            description = "patient email", example = "ygor@gmail.com"
    )
    private String email;

    @Pattern(regexp = "^[0-9]{11}$", message = "Mobile number must be 11 digits")

    @Schema(
            description = "patient mobile number", example = "21980161321"
    )
    private String mobileNumber;

    @NotNull(message = "Birth date cannot be null")
    @Schema(
            description = "patient Birthdate", example = "2000-03-31"
    )
    private LocalDate birthDate;

    @NotNull(message = "Weight cannot be null")
    @Schema(
            description = "patient weight", example = "70.0"
    )
    private Double weight;

    @NotNull(message = "Height cannot be null")
    @Schema(
            description = "patient height", example = "1.75"
    )
    private Double height;

    @Schema(
            description = "patient imc", example = "22.86"
    )
    private Double imc;

    @Schema(
            description = "patient gender", example = "MALE"
    )
    private Gender gender;

    List<ConsultationHistoryDto> consultationHistory;
}
