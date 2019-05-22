package com.mpazi.controller.template;


import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.service.template.RecordTempleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/recordTemplete")
public class RecordTempleteController {
    @Autowired
    @Qualifier("ServiceImpRecordTemplete")
    private RecordTempleteService service;

    @PostMapping("/create")
    @ResponseBody
    public RecordTemplete create(RecordTemplete recordTemplete) {
        return service.create(recordTemplete);
    }

    @PostMapping("/update")
    @ResponseBody
    public RecordTemplete update(RecordTemplete recordTemplete) {
        return service.update(recordTemplete);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public RecordTemplete read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, RecordTemplete> getAll() {
        return service.getAll();
    }


}
