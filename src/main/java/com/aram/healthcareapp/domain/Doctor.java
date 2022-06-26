package com.aram.healthcareapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
@NoArgsConstructor
@ToString
public class Doctor extends AbstractPerson {

    @Getter @Column(name = "speciality")
    private String speciality;

    public Doctor(Integer id, Name name, String speciality) {
        super(id, name);
        this.speciality = speciality;
    }
}
