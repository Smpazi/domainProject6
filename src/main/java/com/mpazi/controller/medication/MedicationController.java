package com.mpazi.controller.medication;

import com.mpazi.domain.medication.Medication;
import com.mpazi.service.medication.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pms/medication")
public class MedicationController {
    @Autowired
    @Qualifier("ServiceImpMedication")
    private MedicationService service;

    @PostMapping("/create")
    @ResponseBody
    public Medication create(Medication medication) {
        return service.create(medication);
    }

    @PostMapping("/update")
    @ResponseBody
    public Medication update(Medication medication) {
        return service.update(medication);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Medication read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Medication> getAll() {
        return service.getAll();
    }

}
