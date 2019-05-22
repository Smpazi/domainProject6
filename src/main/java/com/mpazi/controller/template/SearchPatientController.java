package com.mpazi.controller.template;

import com.mpazi.domain.information.Patient;
import com.mpazi.domain.template.SearchPatient;
import com.mpazi.service.template.SearchPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
@RestController
@RequestMapping("/searchPatient")
public class SearchPatientController {
    @Autowired
    @Qualifier("ServiceImpSearchPatient")
    private SearchPatientService service;

    @PostMapping("/create")
    @ResponseBody
    public SearchPatient create(SearchPatient searchPatient) {
        return service.create(searchPatient);
    }

    @PostMapping("/update")
    @ResponseBody
    public SearchPatient update(SearchPatient searchPatient) {
        return service.update(searchPatient);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public SearchPatient read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, SearchPatient> getAll() {
        return service.getAll();
    }

}
