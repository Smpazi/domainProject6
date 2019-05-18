package com.mpazi.repository.template;

import com.mpazi.domain.template.ReferralLetterTemplete;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface ReferralLetterTemplateRepository extends IRepository<ReferralLetterTemplete, String> {
    Set<ReferralLetterTemplete> getAll();
}
