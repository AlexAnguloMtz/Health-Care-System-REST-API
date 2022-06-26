package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.exception.DoctorDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ClientErrorExceptionHandler extends AbstractExceptionHandler {

    @ExceptionHandler(DoctorDoesNotExistException.class)
    ResponseEntity<String> handleDoctorDoesNotExist(DoctorDoesNotExistException exception) {
        return mapToResponseEntity(exception, HttpStatus.NOT_FOUND);
    }

}
