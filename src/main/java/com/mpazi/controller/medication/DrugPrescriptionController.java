package com.mpazi.controller.medication;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.service.medication.DrugPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/drugPrescription")
public class DrugPrescriptionController {

    @Autowired
    @Qualifier("ServiceImpDrugPrescription")
    private DrugPrescriptionService service;

    @PostMapping("/create")
    @ResponseBody
    public DrugPrescription create(DrugPrescription drugPrescription) {
        return service.create(drugPrescription);
    }

    @PostMapping("/update")
    @ResponseBody
    public DrugPrescription update(DrugPrescription drugPrescription) {
        return service.update(drugPrescription);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public DrugPrescription read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, DrugPrescription> getAll() {
        return service.getAll();
    }

}
