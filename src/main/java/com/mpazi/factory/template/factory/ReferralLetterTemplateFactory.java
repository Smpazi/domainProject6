package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.ReferralLetterTemplate;

import java.util.Map;

public class ReferralLetterTemplateFactory {

    public static ReferralLetterTemplate getReferralLetter(Map<String, String> values){
        return new ReferralLetterTemplate.Builder()
                .referral_ID(values.get("Referral_ID"))
                .referral_HospitalName(values.get("Referral_HospitalName"))
                .build();

    }
}
