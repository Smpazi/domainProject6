package com.mpazi.controller.information;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.service.information.PatientNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patientNote")
public class PatientNoteController {
    @Autowired
    @Qualifier("ServiceImpPatientNote")
    private PatientNoteService service;

    @PostMapping("/create")
    @ResponseBody
    public PatientNote create(PatientNote patientNote) {
        return service.create(patientNote);
    }

    @PostMapping("/update")
    @ResponseBody
    public PatientNote update(PatientNote patientNote) {
        return service.update(patientNote);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public PatientNote read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, PatientNote> getAll() {
        return service.getAll();
    }

}
