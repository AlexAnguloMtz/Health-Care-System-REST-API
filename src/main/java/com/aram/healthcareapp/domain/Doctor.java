package com.aram.healthcareapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "doctor")
@NoArgsConstructor(force = true)
@Getter
@ToString
public class Doctor extends AbstractPerson {

    @Column(name = "speciality")
    @NotBlank(message = "Please provide a medical speciality")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Please provide a valid medical speciality")
    private final String speciality;

    public Doctor(Integer id, Name name, String speciality) {
        super(id, name);
        this.speciality = speciality;
    }

}
