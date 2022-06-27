package com.aram.healthcareapp.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@Table(name = "patient")
@NoArgsConstructor(force = true)
@ToString
public class Patient extends AbstractPerson {

    @Embedded
    @Valid
    @JsonUnwrapped
    @AttributeOverrides({
        @AttributeOverride(
            name = "socialSecurityNumber",
            column = @Column(name = "social_security_number"))
    })

    private final SocialSecurityNumber socialSecurityNumber;

    public Patient(Integer id, Name name, SocialSecurityNumber socialSecurityNumber) {
        super(id, name);
        this.socialSecurityNumber = socialSecurityNumber;
    }


}
