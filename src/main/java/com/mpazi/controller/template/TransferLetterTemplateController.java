package com.mpazi.controller.template;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.service.template.TransferLetterTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/transferLetterTemplate")
public class TransferLetterTemplateController {
    @Autowired
    @Qualifier("ServiceImpTransferLetterTemplate")
    private TransferLetterTemplateService service;

    @PostMapping("/create")
    @ResponseBody
    public TransferLetterTemplate create(TransferLetterTemplate template) {
        return service.create(template);
    }

    @PostMapping("/update")
    @ResponseBody
    public TransferLetterTemplate update(TransferLetterTemplate template) {
        return service.update(template);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public TransferLetterTemplate read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, TransferLetterTemplate> getAll() {
        return service.getAll();
    }

}
