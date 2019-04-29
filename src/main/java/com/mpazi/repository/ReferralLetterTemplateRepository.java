package com.mpazi.repository;

import com.mpazi.domain.ReferralLetterTemplete;

import java.util.Set;

public interface ReferralLetterTemplateRepository extends IRepository<ReferralLetterTemplete, String> {
    Set<ReferralLetterTemplete> getAll();
}
