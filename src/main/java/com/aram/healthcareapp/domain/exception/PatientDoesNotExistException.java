package com.aram.healthcareapp.domain.exception;

import static java.lang.String.format;

public class PatientDoesNotExistException extends RuntimeException {

    private static final String TEMPLATE = "Patient with id %d does not exist";

    public PatientDoesNotExistException(Integer id) {
        super(format(TEMPLATE, id));
    }
}
