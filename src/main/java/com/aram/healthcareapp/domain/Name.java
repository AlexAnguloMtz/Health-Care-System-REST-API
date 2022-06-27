package com.aram.healthcareapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@NoArgsConstructor(force = true)
@ToString
@Getter
public class Name {

    @NotBlank(message = "Please provide a first name")
    private final String firstName;

    @NotBlank(message = "Please provide a middle name")
    private final String middleName;

    @NotBlank(message = "Please provide a paternal surname")
    private final String paternalSurname;

    @NotBlank(message = "Please provide a maternal surname")
    private final String maternalSurname;

    public Name(String firstName, String middleName, String paternalSurname, String maternalSurname) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
    }
}
