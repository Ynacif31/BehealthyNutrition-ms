package com.ygornacif.patient_api.controller;

import com.ygornacif.patient_api.constants.ApiConstants;
import com.ygornacif.patient_api.constants.PatientConstants;
import com.ygornacif.patient_api.dto.ErrorResponseDto;
import com.ygornacif.patient_api.dto.PatientDto;
import com.ygornacif.patient_api.dto.ResponseDto;
import com.ygornacif.patient_api.service.IPatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for patients in BeHealthyNutrition",
        description = "CRUD REST APIs in BeHealthyNutrition to CREATE, UPDATE, FETCH AND DELETE patient details"
)
@RestController
@RequestMapping(path = "/api/patients", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class PatientController {

    private final IPatientService patientService;

    @Operation(
            summary = "Create Patient REST API",
            description = "REST API to create new Patient inside BeHealthyNutrition"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping
    public ResponseEntity<ResponseDto> createPatient(@Validated @RequestBody PatientDto patientDto) {
        patientService.createPatient(patientDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(ApiConstants.STATUS_201, PatientConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Fetch Patient Details REST API",
            description = "REST API to fetch Patient details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping
    public ResponseEntity<PatientDto> fetchPatient(@RequestParam @Pattern(regexp="(^$|[0-9]{11})",message = "Mobile number must be 11 digits")
                                                    String mobileNumber) {
        PatientDto patientDto = patientService.fetchPatient(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(patientDto);
    }

    @Operation(
            summary = "Update Patient Details REST API",
            description = "REST API to update Patient details based on a email"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updatePatient(
            @Validated @RequestBody PatientDto patientDto,
            @PathVariable Long id) {
        boolean isUpdated = patientService.updatePatient(patientDto);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(ApiConstants.STATUS_200, ApiConstants.MESSAGE_200_PROCESSED));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ApiConstants.STATUS_417, ApiConstants.MESSAGE_417_UPDATE_FAILED));
        }
    }

    @Operation(
            summary = "Delete Patient Details REST API",
            description = "REST API to delete Patient details based on a id"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deletePatient(@PathVariable Long id) {
        boolean isDeleted = patientService.deletePatient(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(ApiConstants.STATUS_200, ApiConstants.MESSAGE_200_PROCESSED));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ApiConstants.STATUS_417, ApiConstants.MESSAGE_417_DELETE_FAILED));
        }
    }

    @Operation(
            summary = "Fetch Patient by ID REST API",
            description = "REST API to fetch a Patient by their ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Patient not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Long id) {
        PatientDto patientDto = patientService.getPatientById(id);
        return ResponseEntity.ok(patientDto);
    }
}