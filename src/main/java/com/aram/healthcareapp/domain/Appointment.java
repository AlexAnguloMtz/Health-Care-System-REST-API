package com.aram.healthcareapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@NoArgsConstructor
@ToString
@Getter
public class Appointment extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medical_office_id")
    private MedicalOffice medicalOffice;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

}
