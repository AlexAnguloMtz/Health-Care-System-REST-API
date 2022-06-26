package com.aram.healthcareapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(force = true)
@ToString
@Getter
public class Name {

    private final String firstName;
    private final String middleName;
    private final String paternalSurname;
    private final String maternalSurname;

    public Name(String firstName, String middleName, String paternalSurname, String maternalSurname) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
    }
}
