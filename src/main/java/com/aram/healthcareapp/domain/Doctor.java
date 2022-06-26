package com.aram.healthcareapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Builder
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

    @Getter @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor", fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

}
