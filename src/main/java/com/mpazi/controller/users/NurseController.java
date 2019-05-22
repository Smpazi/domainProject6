package com.mpazi.controller.users;

import com.mpazi.domain.users.Nurse;
import com.mpazi.service.users.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    @Autowired
    @Qualifier("ServiceImpNurse")
    private NurseService service;

    @PostMapping("/create")
    @ResponseBody
    public Nurse create(Nurse nurse) {
        return service.create(nurse);
    }

    @PostMapping("/update")
    @ResponseBody
    public Nurse update(Nurse nurse) {
        return service.update(nurse);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Nurse read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Nurse> getAll() {
        return service.getAll();
    }

}
