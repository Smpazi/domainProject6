package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.ReferralLetterTemplete;

import java.util.Map;

public class ReferralLetterTemplateFactory {

    public static ReferralLetterTemplete getReferralLetter(Map<String, String> values){
        return new ReferralLetterTemplete.Builder()
                .referral_ID(values.get("Referral_ID"))
                .referral_HospitalName("Referral_HospitalName")
                .build();

    }
}
