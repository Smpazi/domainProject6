package com.mpazi.repository;

import com.mpazi.domain.TransferLetterTemplate;

import java.util.Set;

public interface TranferLetterTemplateRepository extends IRepository<TransferLetterTemplate, String> {
    Set<TransferLetterTemplate> getAll();
}
