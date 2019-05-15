package com.mpazi.repository.other;

import com.mpazi.domain.templete.ReferralLetterTemplete;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface ReferralLetterTemplateRepository extends IRepository<ReferralLetterTemplete, String> {
    Set<ReferralLetterTemplete> getAll();
}
