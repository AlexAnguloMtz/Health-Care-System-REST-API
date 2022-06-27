package com.aram.healthcareapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
@Data
@NoArgsConstructor(force = true)
public class Speciality extends AbstractEntity {

    private static final String NAME_INVALID_FORMAT_MESSAGE =
            "Speciality name must start with uppercase. The rest must be lowercase letters with optional spaces";
    private static final String NAME_REGEX = "^[A-Z][a-z ]+$";
    private static final String NAME_BLANK_MESSAGE = "Please provide a medical speciality name";

    @Column(name = "name")
    @NotBlank(message = NAME_BLANK_MESSAGE)
    @Pattern(regexp = NAME_REGEX, message = NAME_INVALID_FORMAT_MESSAGE)
    private final String name;

    public Speciality(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
