package com.mpazi.service.other;

import com.mpazi.domain.templete.ReferralLetterTemplete;
import com.mpazi.service.IService;

import java.util.Set;

public interface ReferralLetterTemplateService extends IService<ReferralLetterTemplete, String> {
    Set<ReferralLetterTemplete> getAll();
}
