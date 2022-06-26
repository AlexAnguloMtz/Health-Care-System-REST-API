package com.aram.healthcareapp.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor(force = true)
public class SocialSecurityNumber {

    private final String socialSecurityNumber;

}
