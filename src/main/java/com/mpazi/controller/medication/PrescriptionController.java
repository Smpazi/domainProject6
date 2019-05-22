package com.mpazi.controller.medication;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.service.medication.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    @Qualifier("ServiceImpPrescription")
    private PrescriptionService service;

    @PostMapping("/create")
    @ResponseBody
    public Prescription create(Prescription prescription) {
        return service.create(prescription);
    }

    @PostMapping("/update")
    @ResponseBody
    public Prescription update(Prescription prescription) {
        return service.update(prescription);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Prescription read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Prescription> getAll() {
        return service.getAll();
    }

}
