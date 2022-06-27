package com.aram.healthcareapp.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Embeddable
@Data
@NoArgsConstructor(force = true)
public
class SocialSecurityNumber {

    @NotBlank(message = "Please provide a social security number")

    // USA social security number regex
    @Pattern(regexp = "^\\d{3}-\\d{2}-\\d{4}$",
             message = "Social security number must match exactly the following format: XXX-XX-XXXX")

    private final String socialSecurityNumber;

    public SocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }


}
