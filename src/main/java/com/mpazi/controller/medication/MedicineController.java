package com.mpazi.controller.medication;

import com.mpazi.domain.medication.Medicine;
import com.mpazi.service.medication.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pms/check/medicine")
public class MedicineController {
    @Autowired
    @Qualifier("ServiceImpMedicine")
    private MedicineService service;

    @PostMapping("/create")
    @ResponseBody
    public Medicine create(Medicine medicine) {
        return service.create(medicine);
    }

    @PostMapping("/update")
    @ResponseBody
    public Medicine update(Medicine medicine) {
        return service.update(medicine);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Medicine read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Medicine> getAll() {
        return service.getAll();
    }

}
