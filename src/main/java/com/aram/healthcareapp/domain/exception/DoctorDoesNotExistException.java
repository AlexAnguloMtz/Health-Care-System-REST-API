package com.aram.healthcareapp.domain.exception;

import static java.lang.String.format;

public class DoctorDoesNotExistException extends RuntimeException {
    public DoctorDoesNotExistException(Integer id) {
        super(format("Doctor with id %d does not exist", id));
    }
}
