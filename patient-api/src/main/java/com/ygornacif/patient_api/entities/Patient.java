package com.ygornacif.patient_api.entities;

import com.ygornacif.patient_api.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Column(name = "patient_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;

    private String email;

    @Column(name="mobile_number")
    private String mobileNumber;

    private Date birthDate;

    private Double weight;

    private Double height;

    private Double imc;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultationHistory> consultationHistory;
}
