package com.aram.healthcareapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medical_office")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MedicalOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Getter
    private Integer id;

    @Getter @Column(name = "office_number")
    private String officeNumber;

    @Getter @Column(name = "floor")
    private String floor;

    @Getter
    @OneToMany(mappedBy = "medicalOffice")
    Set<Appointment> appointmentSet;


}
