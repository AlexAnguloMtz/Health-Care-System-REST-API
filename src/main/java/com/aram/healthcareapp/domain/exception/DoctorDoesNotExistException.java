package com.aram.healthcareapp.domain.exception;

import static java.lang.String.format;

public class DoctorDoesNotExistException extends RuntimeException {

    private static final String TEMPLATE = "Doctor with id %d does not exist";

    public DoctorDoesNotExistException(Integer id) {
        super(format(TEMPLATE, id));
    }
}
