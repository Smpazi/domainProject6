package com.mpazi.controller.template;

import com.mpazi.domain.template.Treatment;
import com.mpazi.service.template.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/treatment")
public class TreatmentController {
    @Autowired
    @Qualifier("ServiceImpTreatment")
    private TreatmentService service;

    @PostMapping("/create")
    @ResponseBody
    public Treatment create(Treatment treatment) {
        return service.create(treatment);
    }

    @PostMapping("/update")
    @ResponseBody
    public Treatment update(Treatment treatment) {
        return service.update(treatment);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Treatment read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Treatment> getAll() {
        return service.getAll();
    }

}
