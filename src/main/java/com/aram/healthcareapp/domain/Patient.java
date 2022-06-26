package com.aram.healthcareapp.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "patient")
@NoArgsConstructor(force = true)
public class Patient extends AbstractPerson {

    @Embedded
    @JsonUnwrapped
    @AttributeOverrides({
        @AttributeOverride(name = "socialSecurityNumber",
                           column = @Column(name = "social_security_number"))
    })
    private final SocialSecurityNumber socialSecurityNumber;

    public Patient(Integer id, Name name, SocialSecurityNumber socialSecurityNumber) {
        super(id, name);
        this.socialSecurityNumber = socialSecurityNumber;
    }


}
