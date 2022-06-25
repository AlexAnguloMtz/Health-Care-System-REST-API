package com.aram.healthcareapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Getter
    @ManyToOne
    @JoinColumn(name = "medical_office_id")
    private MedicalOffice medicalOffice;

    @Getter @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Getter
    private String patientName;

}
