package com.aram.healthcareapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class MedicalOffice extends AbstractEntity {

    @Getter @Column(name = "office_number")
    private String officeNumber;

    @Getter @Column(name = "floor")
    private String floor;

}
