package com.mpazi.controller.information;


import com.mpazi.domain.information.Appointment;
import com.mpazi.service.information.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    @Qualifier("ServiceImpAppointment")
    private AppointmentService service;

    @PostMapping("/create")
    @ResponseBody
    public Appointment create(Appointment appointment) {
        return service.create(appointment);
    }

    @PostMapping("/update")
    @ResponseBody
    public Appointment update(Appointment appointment) {
        return service.update(appointment);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Appointment read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Appointment> getAll() {
        return service.getAll();
    }

}
