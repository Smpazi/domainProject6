package com.mpazi.controller.information;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.service.information.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/medicalHistory")
public class MedicalHistoryController {
    @Autowired
    @Qualifier("ServiceImpMedicalHistory")
    private MedicalHistoryService service;

    @PostMapping("/create")
    @ResponseBody
    public MedicalHistory create(MedicalHistory medicalHistory) {
        return service.create(medicalHistory);
    }

    @PostMapping("/update")
    @ResponseBody
    public MedicalHistory update(MedicalHistory medicalHistory) {
        return service.update(medicalHistory);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public MedicalHistory read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, MedicalHistory> getAll() {
        return service.getAll();
    }

}
