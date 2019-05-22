package com.mpazi.controller.information;

import com.mpazi.domain.information.Consultation;
import com.mpazi.service.information.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    @Autowired
    @Qualifier("ServiceImpConsultation")
    private ConsultationService service;

    @PostMapping("/create")
    @ResponseBody
    public Consultation create(Consultation consultation) {
        return service.create(consultation);
    }

    @PostMapping("/update")
    @ResponseBody
    public Consultation update(Consultation consultation) {
        return service.update(consultation);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Consultation read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Consultation> getAll() {
        return service.getAll();
    }

}
