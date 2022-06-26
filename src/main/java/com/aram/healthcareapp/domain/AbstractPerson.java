package com.aram.healthcareapp.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@MappedSuperclass
abstract class AbstractPerson extends AbstractEntity {

    @Embedded
    @Getter
    @JsonUnwrapped
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "middleName", column = @Column(name = "middle_name")),
            @AttributeOverride(name = "paternalSurname", column = @Column(name = "paternal_surname")),
            @AttributeOverride(name = "maternalSurname", column = @Column(name = "maternal_surname"))
    })
    private Name name;

    public AbstractPerson(Integer id, Name name) {
        super(id);
        this.name = name;
    }


}
