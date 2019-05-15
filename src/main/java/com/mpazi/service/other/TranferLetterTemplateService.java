package com.mpazi.service.other;

import com.mpazi.domain.templete.TransferLetterTemplate;
import com.mpazi.service.IService;

import java.util.Set;

public interface TranferLetterTemplateService extends IService<TransferLetterTemplate, String> {
    Set<TransferLetterTemplate> getAll();
}
