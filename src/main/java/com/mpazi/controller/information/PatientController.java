package com.mpazi.controller.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.service.information.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
@RestController
@RequestMapping("/patient")
public  class PatientController {
    @Autowired
    @Qualifier("ServiceImpPatient")
    private PatientService service;

    @PostMapping("/create")
    @ResponseBody
    public Patient create(Patient patient) {
        return service.create(patient);
    }

    @PostMapping("/update")
    @ResponseBody
    public Patient update(Patient patient) {
        return service.update(patient);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Patient read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Patient> getAll() {
        return service.getAll();
    }

}
