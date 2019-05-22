package com.mpazi.controller.template;

import com.mpazi.domain.template.ReferralLetterTemplate;
import com.mpazi.service.template.ReferralLetterTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/referralLetterTemplete")
public class ReferralLetterTempleteController {
    @Autowired
    @Qualifier("ServiceImpReferralLetterTemplate")
    private ReferralLetterTemplateService service;

    @PostMapping("/create")
    @ResponseBody
    public ReferralLetterTemplate create(ReferralLetterTemplate letterTemplate) {
        return service.create(letterTemplate);
    }

    @PostMapping("/update")
    @ResponseBody
    public ReferralLetterTemplate update(ReferralLetterTemplate letterTemplate) {
        return service.update(letterTemplate);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ReferralLetterTemplate read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, ReferralLetterTemplate> getAll() {
        return service.getAll();
    }


}
