package com.mpazi.repository.template;

import com.mpazi.domain.template.ReferralLetterTemplate;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface ReferralLetterTemplateRepository extends IRepository<ReferralLetterTemplate, String> {
    Map<String, ReferralLetterTemplate> getAll();
}
