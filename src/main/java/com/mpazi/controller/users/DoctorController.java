package com.mpazi.controller.users;

import com.mpazi.domain.users.Doctor;
import com.mpazi.service.users.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    @Qualifier("ServiceImpDoctor")
    private DoctorService service;

    @PostMapping("/create")
    @ResponseBody
    public Doctor create(Doctor doctor) {
        return service.create(doctor);
    }

    @PostMapping("/update")
    @ResponseBody
    public Doctor update(Doctor doctor) {
        return service.update(doctor);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Doctor read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Doctor> getAll() {
        return service.getAll();
    }


}
