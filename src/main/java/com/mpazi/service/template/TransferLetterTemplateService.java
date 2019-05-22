package com.mpazi.service.template;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.service.IService;

import java.util.Map;

public interface TransferLetterTemplateService extends IService<TransferLetterTemplate, String> {
    Map<String, TransferLetterTemplate> getAll();
}
