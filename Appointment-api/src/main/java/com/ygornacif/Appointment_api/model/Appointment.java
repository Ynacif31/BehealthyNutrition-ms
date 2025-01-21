package com.ygornacif.Appointment_api.model;

import com.ygornacif.Appointment_api.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_appointment")
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private String nutritionistId;

    private String patientId;

    private String notes;

    private Status status;


}
