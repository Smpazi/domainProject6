package com.mpazi.controller.users;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.service.users.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {
    @Autowired
    @Qualifier("ServiceImpReceptionist")
    private ReceptionistService service;

    @PostMapping("/create")
    @ResponseBody
    public Receptionist create(Receptionist receptionist) {
        return service.create(receptionist);
    }

    @PostMapping("/update")
    @ResponseBody
    public Receptionist update(Receptionist receptionist) {
        return service.update(receptionist);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Receptionist read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Receptionist> getAll() {
        return service.getAll();
    }

}
