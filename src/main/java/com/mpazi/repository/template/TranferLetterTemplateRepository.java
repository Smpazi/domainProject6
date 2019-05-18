package com.mpazi.repository.template;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface TranferLetterTemplateRepository extends IRepository<TransferLetterTemplate, String> {
    Set<TransferLetterTemplate> getAll();
}
