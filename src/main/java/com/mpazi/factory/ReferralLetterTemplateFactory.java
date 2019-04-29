package com.mpazi.factory;

import com.mpazi.domain.ReferralLetterTemplete;

public class ReferralLetterTemplateFactory {

    public static ReferralLetterTemplete getReferralLetter(String docName){
        return new ReferralLetterTemplete.Builder().referral_doctorName(docName)
                .build();

    }
}
