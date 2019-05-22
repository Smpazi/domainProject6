package com.mpazi.controller.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.service.users.ClinicEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/clinicEmployee")
public class ClinicEmployeeController {
    @Autowired
    @Qualifier("ServiceImpClinicEmployee")
    private ClinicEmployeeService service;

    @PostMapping("/create")
    @ResponseBody
    public ClinicEmployee create(ClinicEmployee clinicEmployee) {
        return service.create(clinicEmployee);
    }

    @PostMapping("/update")
    @ResponseBody
    public ClinicEmployee update(ClinicEmployee clinicEmployee) {
        return service.update(clinicEmployee);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ClinicEmployee read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, ClinicEmployee> getAll() {
        return service.getAll();
    }


}
