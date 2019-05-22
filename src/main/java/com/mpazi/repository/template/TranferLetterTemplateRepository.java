package com.mpazi.repository.template;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface TranferLetterTemplateRepository extends IRepository<TransferLetterTemplate, String> {
    Map<String, TransferLetterTemplate> getAll();
}
