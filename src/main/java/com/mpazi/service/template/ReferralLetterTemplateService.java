package com.mpazi.service.template;

import com.mpazi.domain.template.ReferralLetterTemplete;
import com.mpazi.service.IService;

import java.util.Set;

public interface ReferralLetterTemplateService extends IService<ReferralLetterTemplete, String> {
    Set<ReferralLetterTemplete> getAll();
}
