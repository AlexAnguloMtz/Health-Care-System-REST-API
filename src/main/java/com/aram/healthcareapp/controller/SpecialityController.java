package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.Speciality;
import com.aram.healthcareapp.domain.exception.ResourceAlreadyExistsException;
import com.aram.healthcareapp.domain.exception.ResourceDoesNotExistException;
import com.aram.healthcareapp.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/specialities")
class SpecialityController {

    private final SpecialityService specialityService;

    @Autowired
    SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping("/all")
    ResponseEntity<Collection<Speciality>> findAll() {
        return new ResponseEntity<>(specialityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Speciality> findSpeciality(@PathVariable Integer id) {
        return new ResponseEntity<>(findById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Speciality> saveSpeciality(@RequestBody Speciality speciality) {
        if(alreadyExists(speciality)) {
            throw new ResourceAlreadyExistsException("This speciality already exists");
        }
        return new ResponseEntity<>(specialityService.save(speciality), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Speciality> updateSpeciality(@RequestBody @Valid Speciality specialityRequestBody,
                                                @PathVariable Integer id) {
        Optional<Speciality> specialityOptional = specialityService.findById(id);
        if(specialityOptional.isPresent()) {
            Speciality oldSpeciality = specialityOptional.get();
            String newName = specialityRequestBody.getName();
            Speciality newSpeciality = new Speciality(oldSpeciality.getId(), newName);
            return new ResponseEntity<>(specialityService.save(newSpeciality), HttpStatus.OK);
        }
        return new ResponseEntity<>(specialityService.save(specialityRequestBody), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    HttpStatus delete(@PathVariable Integer id) {
        specialityService.deleteById(id);
        return HttpStatus.OK;
    }

    private boolean alreadyExists(Speciality speciality) {
        Optional<Speciality> specialityOptional = specialityService.findByName(speciality.getName());
        return specialityOptional.isPresent();
    }

    private Speciality findById(Integer id) {
        Optional<Speciality> specialityOptional = specialityService.findById(id);
        return specialityOptional.orElseThrow(
                () -> new ResourceDoesNotExistException("This speciality does not exist"));
    }

}
