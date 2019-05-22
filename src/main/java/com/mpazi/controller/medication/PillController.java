package com.mpazi.controller.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.service.medication.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pill")
public class PillController {
    @Autowired
    @Qualifier("ServiceImpPill")
    private PillService service;

    @PostMapping("/create")
    @ResponseBody
    public Pill create(Pill pill) {
        return service.create(pill);
    }

    @PostMapping("/update")
    @ResponseBody
    public Pill update(Pill pill) {
        return service.update(pill);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Pill read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Pill> getAll() {
        return service.getAll();
    }

}
