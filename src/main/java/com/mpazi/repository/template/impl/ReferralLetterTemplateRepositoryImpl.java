package com.mpazi.repository.template.impl;

import com.mpazi.domain.template.ReferralLetterTemplate;
import com.mpazi.repository.template.ReferralLetterTemplateRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("InMemoryReferralLetterTemplate")

public class ReferralLetterTemplateRepositoryImpl implements ReferralLetterTemplateRepository {

    private  static ReferralLetterTemplateRepositoryImpl repository = null;
    private Map<String, ReferralLetterTemplate> referralLetterTempleteList;

    private ReferralLetterTemplateRepositoryImpl(){
        this.referralLetterTempleteList = new HashMap<>();
    }

    public static ReferralLetterTemplateRepositoryImpl getRepository(){
        if(repository == null)
            repository = new ReferralLetterTemplateRepositoryImpl();
        return repository;
    }

    @Override
    public Map<String, ReferralLetterTemplate> getAll() {
        return referralLetterTempleteList;
    }

    @Override
    public ReferralLetterTemplate create(ReferralLetterTemplate referralLetterTemplate) {
        referralLetterTempleteList.put(referralLetterTemplate.getReferral_ID(), referralLetterTemplate);
        ReferralLetterTemplate savedReferral = referralLetterTempleteList.get(referralLetterTemplate.getReferral_ID());
        return savedReferral;
    }

    @Override
    public ReferralLetterTemplate update(ReferralLetterTemplate referralLetterTemplate) {
        referralLetterTempleteList.put(referralLetterTemplate.getReferral_ID(), referralLetterTemplate);
        ReferralLetterTemplate savedReferral = referralLetterTempleteList.get(referralLetterTemplate.getReferral_ID());
        return savedReferral;
    }

    @Override
    public void delete(String referral_ID) {
        referralLetterTempleteList.remove(referral_ID);
    }

    @Override
    public ReferralLetterTemplate read(String referral_ID) {
        ReferralLetterTemplate templete =referralLetterTempleteList.get(referral_ID);
        return templete;
    }
}
