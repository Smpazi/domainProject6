package com.mpazi.service.template;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.service.IService;

import java.util.Set;

public interface TranferLetterTemplateService extends IService<TransferLetterTemplate, String> {
    Set<TransferLetterTemplate> getAll();
}
