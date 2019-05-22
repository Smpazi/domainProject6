package com.mpazi.service.template;

import com.mpazi.domain.template.ReferralLetterTemplate;
import com.mpazi.service.IService;

import java.util.Map;

public interface ReferralLetterTemplateService extends IService<ReferralLetterTemplate, String> {
    Map<String, ReferralLetterTemplate> getAll();
}
