package com.mpazi.controller.information;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.service.information.CheckUpRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/checkUpRecord")
public class CheckUpRecordController {
    @Autowired
    @Qualifier("ServiceImpCheckUpRecord")
    private CheckUpRecordService service;

    @PostMapping("/create")
    @ResponseBody
    public CheckUpRecord create(CheckUpRecord checkUpRecord) {
        return service.create(checkUpRecord);
    }

    @PostMapping("/update")
    @ResponseBody
    public CheckUpRecord update(CheckUpRecord checkUpRecord) {
        return service.update(checkUpRecord);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public CheckUpRecord read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, CheckUpRecord> getAll() {
        return service.getAll();
    }

}
