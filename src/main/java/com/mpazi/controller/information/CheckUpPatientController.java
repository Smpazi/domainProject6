package com.mpazi.controller.information;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.service.information.CheckUpPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/checkUpPatient")
public class CheckUpPatientController {
    @Autowired
    @Qualifier("ServiceImpCheckUpPatient")
    private CheckUpPatientService service;

    @PostMapping("/create")
    @ResponseBody
    public CheckUpPatient create(CheckUpPatient checkUpPatient) {
        return service.create(checkUpPatient);
    }

    @PostMapping("/update")
    @ResponseBody
    public CheckUpPatient update(CheckUpPatient checkUpPatient) {
        return service.update(checkUpPatient);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public CheckUpPatient read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, CheckUpPatient> getAll() {
        return service.getAll();
    }

}
