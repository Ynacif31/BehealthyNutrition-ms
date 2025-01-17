package com.ygornacif.patient_api.exceptions;

public class ConsultationHistoryNotFoundException extends RuntimeException {
    public ConsultationHistoryNotFoundException(String message) {
        super("History not found");
    }
}
