package com.aram.healthcareapp.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "doctor")
@NoArgsConstructor(force = true)
@Getter
@ToString
public class Doctor extends AbstractPerson {

    @Valid
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private final Speciality speciality;

    public Doctor(Integer id, Name name, Speciality speciality) {
        super(id, name);
        this.speciality = speciality;
    }

}
