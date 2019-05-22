package com.mpazi.controller.login;

import com.mpazi.domain.login.Registration;
import com.mpazi.service.login.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    @Qualifier("ServiceImpRegistration")
    private RegistrationService service;

    @PostMapping("/create")
    @ResponseBody
    public Registration create(Registration registration) {
        return service.create(registration);
    }

    @PostMapping("/update")
    @ResponseBody
    public Registration update(Registration registration) {
        return service.update(registration);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Registration read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Registration> getAll() {
        return service.getAll();
    }

}
