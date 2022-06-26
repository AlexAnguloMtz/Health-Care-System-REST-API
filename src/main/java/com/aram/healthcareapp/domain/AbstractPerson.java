package com.aram.healthcareapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@MappedSuperclass
abstract class AbstractPerson extends AbstractEntity {

    @Getter
    @Column(name = "paternal_surname")
    protected String paternalSurname;

    @Getter
    @Column(name = "maternal_surname")
    protected String maternalSurname;

    public AbstractPerson(Integer id, String paternalSurname, String maternalSurname) {
        super(id);
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
    }

}
