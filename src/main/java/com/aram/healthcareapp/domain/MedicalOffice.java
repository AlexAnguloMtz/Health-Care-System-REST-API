package com.aram.healthcareapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medical_office")
@NoArgsConstructor
@ToString
public class MedicalOffice extends AbstractEntity {

    @Getter @Column(name = "office_number")
    private String officeNumber;

    @Getter @Column(name = "floor")
    private String floor;

}
