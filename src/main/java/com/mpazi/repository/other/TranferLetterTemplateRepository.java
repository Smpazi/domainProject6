package com.mpazi.repository.other;

import com.mpazi.domain.templete.TransferLetterTemplate;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface TranferLetterTemplateRepository extends IRepository<TransferLetterTemplate, String> {
    Set<TransferLetterTemplate> getAll();
}
