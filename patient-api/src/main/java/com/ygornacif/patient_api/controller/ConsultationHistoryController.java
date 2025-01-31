package com.ygornacif.patient_api.controller;

import com.ygornacif.patient_api.constants.ApiConstants;
import com.ygornacif.patient_api.constants.ConsultationHistoryConstants;
import com.ygornacif.patient_api.dto.ConsultationHistoryDto;
import com.ygornacif.patient_api.dto.ErrorResponseDto;
import com.ygornacif.patient_api.dto.ResponseDto;
import com.ygornacif.patient_api.service.IConsultationHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/consultationHistory", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@Tag(
        name = "CRUD REST APIs for consultation history in BeHealthyNutrition",
        description = "CRUD REST APIs in BeHealthyNutrition to CREATE, UPDATE, FETCH AND DELETE consultation history details")
public class ConsultationHistoryController {
    
    private final IConsultationHistoryService consultationHistoryService;

    @Operation(
            summary = "Create ConsultationHistory REST API",
            description = "REST API to create new ConsultationHistory inside BeHealthyNutrition"
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
    public ResponseEntity<ResponseDto> createHistory(@Validated @RequestBody ConsultationHistoryDto consultationHistoryDto) {
        consultationHistoryService.createConsultationHistory(consultationHistoryDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(ApiConstants.STATUS_201, ConsultationHistoryConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch ConsultationHistory REST API",
            description = "REST API to fetch ConsultationHistory inside BeHealthyNutrition"
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
    @GetMapping("/{patientId}")
    public ResponseEntity<List<ConsultationHistoryDto>> fetchHistory(@PathVariable Long patientId) {
        List<ConsultationHistoryDto> consultationHistoryList = consultationHistoryService.fetchConsultationHistoryByPatientId(patientId);
        return ResponseEntity.status(HttpStatus.OK).body(consultationHistoryList);
    }

    @Operation(
            summary = "Update ConsultationHistory REST API",
            description = "REST API to Update ConsultationHistory inside BeHealthyNutrition"
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
    @PutMapping
    public ResponseEntity<ResponseDto> updateConsultationHistory(@Validated @RequestBody ConsultationHistoryDto consultationHistoryDto, Long id){
        consultationHistoryService.updateConsultationHistory(consultationHistoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ApiConstants.STATUS_200, ApiConstants.MESSAGE_200_PROCESSED));
    }

    @Operation(
            summary = "Delete ConsultationHistory REST API",
            description = "REST API to delete ConsultationHistory inside BeHealthyNutrition"
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
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteConsultationHistory(@PathVariable Long id){
        consultationHistoryService.deleteConsultationHistory(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ApiConstants.STATUS_200, ApiConstants.MESSAGE_200_PROCESSED));
    }
}
