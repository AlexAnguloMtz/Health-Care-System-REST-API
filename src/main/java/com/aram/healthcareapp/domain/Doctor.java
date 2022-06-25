package com.aram.healthcareapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Getter
    private Integer id;

    @Getter @Column(name = "paternal_surname")
    private String paternalSurname;

    @Getter @Column(name = "maternal_surname")
    private String maternalSurname;

    @Getter @Column(name = "speciality")
    private String speciality;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

}
